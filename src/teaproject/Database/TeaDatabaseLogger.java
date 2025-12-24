package teaproject.Database;

import java.sql.*;
import java.time.LocalDateTime;

public class TeaDatabaseLogger {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/teaproject";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void logTeaMade(int numberOfCups) {
        String sql = "INSERT INTO logs (cups, made_at) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, numberOfCups);
            pstmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            pstmt.executeUpdate();
            System.out.println("Tea logged to database: " + numberOfCups + " cups");

        } catch (SQLException e) {
            System.err.println("Error logging tea to database: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static int getMonthlyLogs() {
        String sql = "SELECT SUM(cups) FROM logs WHERE MONTH(made_at) = MONTH(CURDATE()) AND YEAR(made_at) = YEAR(CURDATE())";
        int totalCups = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) { 
                totalCups = rs.getInt(1); 
            } else {
                System.out.println("No logs found for today.");
            }

        } catch (SQLException e) {
            System.err.println("Error getting today's tea logs: " + e.getMessage());
            e.printStackTrace();
        }

        return totalCups;
    }

    public static int getDailyLogs(){
        String sql = "SELECT SUM(cups) FROM logs WHERE made_at >= CURDATE()";
        int totalCups = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) { 
                totalCups = rs.getInt(1); 
            } else {
                System.out.println("No logs found for today.");
            }

        } catch (SQLException e) {
            System.err.println("Error getting today's tea logs: " + e.getMessage());
            e.printStackTrace();
        }

        return totalCups;   
    }

}
