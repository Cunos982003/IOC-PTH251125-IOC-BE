import java.sql.*;

public class TaskManagement {

    public void addTask(String taskName, String status) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement call =
                     conn.prepareCall("CALL add_task(?, ?)")) {

            call.setString(1, taskName);
            call.setString(2, status);
            call.execute();

            System.out.println("Thêm thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void updateTaskStatus(int taskId, String status) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement call = conn.prepareCall("CALL update_task_status(?, ?)")) {

            call.setInt(1, taskId);
            call.setString(2, status);
            call.execute();

            System.out.println("Cập nhật thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void listTasks() {
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM list_tasks()")) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }


    public void deleteTask(int taskId) {
        try (Connection conn = ConnectionDB.getConnection();
             CallableStatement call = conn.prepareCall("CALL delete_task(?)")) {

            call.setInt(1, taskId);
            call.execute();

            System.out.println("Xóa thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void searchTaskByName(String name) {
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement("SELECT * FROM search_task_by_name(?)")) {

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("task_name") + " | " +
                                rs.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }

    public void taskStatistics() {
        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement("SELECT * FROM task_statistics()")) {

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Đã hoàn thành: " + rs.getInt("completed"));
                System.out.println("Chưa hoàn thành: " + rs.getInt("not_completed"));
            }

        } catch (SQLException e) {
            System.out.println("Lỗi DB: " + e.getMessage());
        }
    }
}