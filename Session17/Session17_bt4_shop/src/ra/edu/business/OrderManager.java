package ra.edu.business;

import ra.edu.model.Customer;
import ra.edu.model.Product;
import ra.edu.util.ConnectionDB;

import java.sql.*;
import java.text.DecimalFormat;

public class OrderManager {
    public void addProduct(Product product) {

        String checkSql = "SELECT 1 FROM products WHERE name=?";
        String insertSql = "INSERT INTO products(name, price) VALUES(?,?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement check = conn.prepareStatement(checkSql)) {

            check.setString(1, product.getName());
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Sản phẩm đã tồn tại!");
                return;
            }

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {
                insert.setString(1, product.getName());
                insert.setDouble(2, product.getPrice());
                insert.executeUpdate();
                System.out.println("Thêm thành công!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void addCustomer(Customer customer) {

        String checkSql = "SELECT 1 FROM customers WHERE email=?";
        String insertSql = "INSERT INTO customers(name, email) VALUES(?,?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement check = conn.prepareStatement(checkSql)) {

            check.setString(1, customer.getEmail());
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Email đã tồn tại!");
                return;
            }

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {
                insert.setString(1, customer.getName());
                insert.setString(2, customer.getEmail());
                insert.executeUpdate();
                System.out.println("Thêm khách hàng thành công!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void updateCustomer(int id, Customer customer) {

        String checkSql = "SELECT 1 FROM customers WHERE id=?";
        String updateSql = "UPDATE customers SET name=?, email=? WHERE id=?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement check = conn.prepareStatement(checkSql)) {

            check.setInt(1, id);
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Không tìm thấy khách hàng!");
                return;
            }

            try (PreparedStatement update = conn.prepareStatement(updateSql)) {
                update.setString(1, customer.getName());
                update.setString(2, customer.getEmail());
                update.setInt(3, id);
                update.executeUpdate();
                System.out.println("Cập nhật thành công!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void createOrder(int customerId, int productId, int quantity) {

        String productSql = "SELECT price FROM products WHERE id=?";
        String checkCustomer = "SELECT 1 FROM customers WHERE id=?";
        String insertOrder =
                "INSERT INTO orders(customer_id, order_date, total_amount) VALUES(?,?,?)";

        try (Connection conn = ConnectionDB.getConnection()) {

            conn.setAutoCommit(false); // Bắt đầu transaction

            // Kiểm tra customer tồn tại
            try (PreparedStatement checkCus = conn.prepareStatement(checkCustomer)) {
                checkCus.setInt(1, customerId);
                if (!checkCus.executeQuery().next()) {
                    System.out.println("Không tìm thấy khách hàng!");
                    conn.rollback();
                    return;
                }
            }

            double price;

            // Lấy giá sản phẩm
            try (PreparedStatement productStmt = conn.prepareStatement(productSql)) {
                productStmt.setInt(1, productId);
                ResultSet rs = productStmt.executeQuery();

                if (!rs.next()) {
                    System.out.println("Không tìm thấy sản phẩm!");
                    conn.rollback();
                    return;
                }

                price = rs.getDouble("price");
            }

            double total = price * quantity;

            // Insert order
            try (PreparedStatement orderStmt = conn.prepareStatement(insertOrder)) {
                orderStmt.setInt(1, customerId);
                orderStmt.setDate(2, Date.valueOf(java.time.LocalDate.now()));
                orderStmt.setDouble(3, total);
                orderStmt.executeUpdate();
            }

            conn.commit(); // Thành công
            System.out.println("Tạo đơn thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void listAllOrders() {

        String sql = """
        SELECT o.id, c.name, o.order_date, o.total_amount
        FROM orders o
        JOIN customers c ON o.customer_id = c.id
        ORDER BY o.id
    """;

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            DecimalFormat df = new DecimalFormat("#,###");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getDate("order_date") + " | " +
                                df.format(rs.getDouble("total_amount")) + " VND"
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void getOrdersByCustomer(int customerId) {

        String sql = "SELECT id, order_date, total_amount FROM orders WHERE customer_id=?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getDate("order_date") + " | " +
                                rs.getDouble("total_amount")
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

}
