package ra.edu.business;

import ra.edu.model.Book;
import ra.edu.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {
    public void addBook(Book book) {

        String checkSql = "SELECT 1 FROM books WHERE title=? AND author=?";
        String insertSql =
                "INSERT INTO books(title, author, published_year, price) VALUES(?,?,?,?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement check = conn.prepareStatement(checkSql)) {

            check.setString(1, book.getTitle());
            check.setString(2, book.getAuthor());

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                System.out.println("Sách đã tồn tại!");
                return;
            }

            try (PreparedStatement insert = conn.prepareStatement(insertSql)) {
                insert.setString(1, book.getTitle());
                insert.setString(2, book.getAuthor());
                insert.setInt(3, book.getPublishedYear());
                insert.setDouble(4, book.getPrice());

                insert.executeUpdate();
                System.out.println("Thêm thành công!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }

    }

    public void updateBook(int id, Book book) {

        String checkSql = "SELECT 1 FROM books WHERE id=?";
        String updateSql =
                "UPDATE books SET title=?, author=?, published_year=?, price=? WHERE id=?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement check = conn.prepareStatement(checkSql)) {

            check.setInt(1, id);
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Không tìm thấy sách!");
                return;
            }

            try (PreparedStatement update = conn.prepareStatement(updateSql)) {
                update.setString(1, book.getTitle());
                update.setString(2, book.getAuthor());
                update.setInt(3, book.getPublishedYear());
                update.setDouble(4, book.getPrice());
                update.setInt(5, id);

                update.executeUpdate();
                System.out.println("Cập nhật thành công!");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void deleteBook(int id) {

        String sql = "DELETE FROM books WHERE id=?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Xóa thành công!");
            else
                System.out.println("Không tìm thấy sách!");

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public List<Book> findBooksByAuthor(String author) {

        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE author ILIKE ?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + author + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("published_year"),
                        rs.getDouble("price")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }

        return list;
    }

    public void listAllBooks() {

        String sql = "SELECT * FROM books ORDER BY id";

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getInt("published_year") + " | " +
                                rs.getDouble("price")
                );
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }
}
