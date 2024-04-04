/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
/**
 *
 * @author hoangquangthang
 */
public class DatabaseConnection {
     private static Connection connection;
     private static final String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLBH;encrypt=true;trustServerCertificate=true";
   private static final String username = "sa";
   private static final String password = "Password.1"; // phụ thuộc tài khoản đăng nhập azude
    // Phương thức tạo kết nối
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
