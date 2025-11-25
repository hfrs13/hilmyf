package taskmanager;

import java.sql.*;
import java.util.ArrayList;

public class TaskDAO {

    public static void addTask(String taskName) {
        String sql = "INSERT INTO tasks (task_name) VALUES (?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, taskName);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error tambah tugas: " + e.getMessage());
        }
    }

    public static ArrayList<String> getAllTasks() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT task_name FROM tasks";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(rs.getString("task_name"));
            }

        } catch (SQLException e) {
            System.out.println("Error ambil tugas: " + e.getMessage());
        }
        return list;
    }

    public static void updateTask(String oldTask, String newTask) {
        String sql = "UPDATE tasks SET task_name=? WHERE task_name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newTask);
            stmt.setString(2, oldTask);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error update tugas: " + e.getMessage());
        }
    }

    public static void deleteTask(String taskName) {
        String sql = "DELETE FROM tasks WHERE task_name=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, taskName);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error hapus tugas: " + e.getMessage());
        }
    }
}
