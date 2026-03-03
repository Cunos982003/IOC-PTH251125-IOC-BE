package re.edu.business.impl;

import re.edu.business.IProductService;
import re.edu.model.Product;
import re.edu.util.ConnectionDB;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class ProductServiceImpl implements IProductService {
    private final static List<Product> products = new ArrayList<>();

    static {
        try (Connection conn = ConnectionDB.getConnection();
             Statement st = conn.createStatement()) {

            conn.setAutoCommit(false);

            ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM Product");
            rs.next();
            int count = rs.getInt(1);

            if (count == 0) {

                st.executeUpdate("""
                INSERT INTO Product
                (Product_Name, Product_Price, Product_Title, Product_Created, Product_Catalog, Product_Status)
                VALUES
                ('IPhone 14 Pro', 499.99, 'Apple Flagship 2022', CURRENT_DATE, 'Electronics', true),
                ('IPhone 15 Pro', 699.99, 'Apple Flagship 2023', CURRENT_DATE, 'Electronics', true),
                ('IPhone 17 Pro', 999.99, 'Future Model', CURRENT_DATE, 'Electronics', true),
                ('IPhone 8', 199.99, 'Old Generation', CURRENT_DATE, 'Electronics', false),
                ('IPhone XS', 299.99, 'Classic Model', CURRENT_DATE, 'Electronics', true)
            """);

                conn.commit();
                System.out.println("✔ Insert dữ liệu mẫu thành công!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Product p) {

        if (p.getName().isBlank() ||
                p.getTitle().isBlank() ||
                p.getCatalog().isBlank()) {
            throw new RuntimeException("Dữ liệu không được để trống");
        }

        if (p.getPrice() <= 0) {
            throw new RuntimeException("Giá phải > 0");
        }

        Connection conn = null;

        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);

            CallableStatement cs =
                    conn.prepareCall("CALL add_product(?,?,?,?,?)");

            cs.setString(1, p.getName());
            cs.setDouble(2, p.getPrice());
            cs.setString(3, p.getTitle());
            cs.setDate(4, Date.valueOf(p.getCreated()));
            cs.setString(5, p.getCatalog());

            cs.execute();
            conn.commit();

            System.out.println("✔ Thêm sản phẩm thành công!");

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi thêm sản phẩm", e);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Product p) {

        Connection conn = null;

        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);

            CallableStatement cs =
                    conn.prepareCall("CALL update_product(?,?,?,?,?,?,?)");

            cs.setInt(1, p.getId());
            cs.setString(2, p.getName());
            cs.setDouble(3, p.getPrice());
            cs.setString(4, p.getTitle());
            cs.setDate(5, Date.valueOf(p.getCreated()));
            cs.setString(6, p.getCatalog());
            cs.setBoolean(7, p.isStatus());

            cs.execute();
            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi cập nhật sản phẩm", e);
        }
    }

    @Override
    public void delete(Integer id) {

        Connection conn = null;

        try {
            conn = ConnectionDB.getConnection();
            conn.setAutoCommit(false);

            CallableStatement cs =
                    conn.prepareCall("CALL delete_product(?)");

            cs.setInt(1, id);
            cs.execute();

            conn.commit();

        } catch (Exception e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new RuntimeException("Lỗi khi xóa sản phẩm", e);
        }
    }

    @Override
    public Product findById(Integer id) {

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement("SELECT * FROM get_product_by_id(?)")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapResultSetToProduct(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Lỗi khi tìm sản phẩm theo ID", e);
        }
        return null;
    }



    @Override
    public List<Product> findAll() {

        List<Product> list = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("SELECT * FROM get_all_products()");
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi lấy danh sách sản phẩm", e);
        }
        return list;
    }

    @Override
    public List<Product> searchByName(String name) {

        List<Product> list = new ArrayList<>();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("SELECT * FROM search_product(?)")) {

            cs.setString(1, name);
            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                list.add(mapResultSetToProduct(rs));
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi tìm kiếm sản phẩm", e);
        }
        return list;
    }


    @Override
    public Map<String, Integer> countByCatalog() {

        Map<String, Integer> map = new LinkedHashMap<>();

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("SELECT * FROM count_by_catalog()");
             ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                map.put(rs.getString(1), rs.getInt(2));
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi thống kê", e);
        }

        return map;
    }

    @Override
    public boolean checkCatalogExists(String catalog) {

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("SELECT check_catalog_exists(?)")) {

            cs.setString(1, catalog);
            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                return rs.getBoolean(1);
            }

        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi kiểm tra catalog", e);
        }
        return false;
    }

    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        return new Product(
                rs.getInt("Product_Id"),
                rs.getString("Product_Name"),
                rs.getDouble("Product_Price"),
                rs.getString("Product_Title"),
                rs.getDate("Product_Created").toLocalDate(),
                rs.getString("Product_Catalog"),
                rs.getBoolean("Product_Status")
        );
    }
}