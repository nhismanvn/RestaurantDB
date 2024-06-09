/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ADMIN
 */
import java.sql.*;

public class RestaurantImageDAO {

    public void createImage(String imageUrl, String description) {
        String sql = "INSERT INTO RestaurantImages (image_url, description) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, imageUrl);
            pstmt.setString(2, description);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readImages() {
        String sql = "SELECT * FROM RestaurantImages";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String imageUrl = rs.getString("image_url");
                String description = rs.getString("description");
                System.out.println(id + ": " + imageUrl + " - " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateImage(int id, String imageUrl, String description) {
        String sql = "UPDATE RestaurantImages SET image_url = ?, description = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, imageUrl);
            pstmt.setString(2, description);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteImage(int id) {
        String sql = "DELETE FROM RestaurantImages WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        RestaurantImageDAO dao = new RestaurantImageDAO();
        dao.createImage("http://example.com/image1.jpg", "Description for image 1");
        dao.readImages();
        dao.updateImage(1, "http://example.com/image1_updated.jpg", "Updated description for image 1");
        dao.deleteImage(1);
    }
}
   
