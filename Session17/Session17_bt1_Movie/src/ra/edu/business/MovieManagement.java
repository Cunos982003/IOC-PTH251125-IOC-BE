package ra.edu.business;

import ra.edu.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

public class MovieManagement {

    private boolean isValidYear(int year) {
        int currentYear = Year.now().getValue();
        return year >= 1900 && year <= currentYear;
    }

    public void addMovie(String title, String director, int year) {

        if (title.isBlank() || director.isBlank()) {
            System.out.println("Không được để trống!");
            return;
        }

        if (!isValidYear(year)) {
            System.out.println("Năm không hợp lệ!");
            return;
        }

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL add_movie(?, ?, ?)")) {

            cs.setString(1, title);
            cs.setString(2, director);
            cs.setInt(3, year);

            cs.execute();
            System.out.println("Thêm phim thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi thêm phim: " + e.getMessage());
        }
    }

    public void listMovies() {

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("SELECT * FROM list_movies()")) {

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + " | Title: " + rs.getString("title")
                        + " | Director: " + rs.getString("director")
                        + " | Year: " + rs.getInt("year"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi hiển thị: " + e.getMessage());
        }
    }

    public void updateMovie(int id, String title, String director, int year) {

        if (!isValidYear(year)) {
            System.out.println("Năm không hợp lệ!");
            return;
        }

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL update_movie(?, ?, ?, ?)")) {

            cs.setInt(1, id);
            cs.setString(2, title);
            cs.setString(3, director);
            cs.setInt(4, year);

            int rows = cs.executeUpdate();

            System.out.println("Cập nhật thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật: " + e.getMessage());
        }
    }

    public void deleteMovie(int id) {

        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement cs =
                     conn.prepareCall("CALL delete_movie(?)")) {

            cs.setInt(1, id);
            cs.execute();
            System.out.println("Xóa thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi xóa: " + e.getMessage());
        }
    }
}
