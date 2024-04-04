/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.SanPham;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author hoangquangthang
 */
public class SanPhamDao {
     private Connection connection;
   //tạo ra function trả về kiểu dữ liệu là list 
     public SanPhamDao() {
        // Lấy kết nối từ lớp DatabaseConnection
        connection = DatabaseConnection.getConnection();
    }
   public List<SanPham> getAllSanPham() {
       List<SanPham> sanphams = new ArrayList<>();
       try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SANPHAM");
            // resultSet là kết quả được trả về từ CSDL  thực hiện lặp add vào list 
            while (resultSet.next()) {
                int maSP = resultSet.getInt("ma_sp");
                String tenSP = resultSet.getString("ten_sp");
                double gia = resultSet.getDouble("gia");
                SanPham sanpham = new SanPham(maSP,tenSP,gia);
                sanphams.add(sanpham);
            }
       } catch (SQLException e) {
           
       }
       
       return sanphams;
   }
   // xây dựng thêm sản phẩm 
   public void addSanPham(SanPham sp) {
       try {
           String sql = "INSERT INTO SANPHAM (ma_sp,ten_sp,gia) VALUES (?,?,?)";
           PreparedStatement statement = connection.prepareStatement(sql); // hàm này đẻ cây lệnh SQL
           statement.setInt(1, sp.getMaSp());
           statement.setString(2, sp.getTenSp());
           statement.setDouble(3, sp.getGia());
           statement.executeUpdate();
           statement.close();
           
       } catch (SQLException e) {
       
       }
   
   }
   //xây dựng sửa sản phẩm 
   public void updateSanPham(SanPham sp) {
       try {
           String sql = "UPDATE SANPHAM SET ten_sp = ?,gia = ? WHERE ma_sp = ?";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setString(1, sp.getTenSp());
           statement.setDouble(2, sp.getGia());
           statement.setInt(3, sp.getMaSp());
           statement.executeUpdate();
           statement.close();
       } catch (SQLException e) {
           // nếu muốn hiển thị lỗi 
           e.printStackTrace();
       }
   }
    public void deleteSanPham(int id) {
       try {
           String sql = "DELETE FROM SANPHAM WHERE ma_sp = ?";
           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setInt(1, id);
           statement.executeUpdate();
           statement.close();
       } catch (SQLException e) {
           // nếu muốn hiển thị lỗi 
           e.printStackTrace();
       }
   }
 
}
