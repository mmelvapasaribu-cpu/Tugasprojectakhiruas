/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KRS;

/**
 *
 * @author ASUS
 */
public class KRSDao {
     private Connection connection;

    public KRSDao() {
        connection = DBConnection.getConnection();
    }

    public int create(KRS krs) {
        try {
            String sql = "INSERT INTO krs (NIM, courseCode, semester) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, krs.getStudent().getNim());
            stmt.setString(2, krs.getCourse().getCode());
            stmt.setInt(3, krs.getSemester());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<KRS> getAll() {
        List<KRS> krsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM krs";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nim = rs.getString("NIM");
                String courseCode = rs.getString("courseCode");
                int semester = rs.getInt("semester");

                krsList.add(new KRS(nim, courseCode, semester));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return krsList;
    }

    public List<KRS> getByNim(String nim) {
        List<KRS> krsList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM krs WHERE NIM=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nim);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String courseCode = rs.getString("courseCode");
                int semester = rs.getInt("semester");

                krsList.add(new KRS(nim, courseCode, semester));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return krsList;
    }

    public int update(KRS krs, String nim, String oldCourseCode) {
        try {
            String sql = "UPDATE krs SET courseCode=?, semester=? WHERE NIM=? AND courseCode=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, krs.getCourse(). getCode());
            stmt.setInt(2, krs.getSemester());
            stmt.setString(3, nim);
            stmt.setString(4, oldCourseCode);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String nim, String courseCode) {
        try {
            String sql = "DELETE FROM krs WHERE NIM=? AND courseCode=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.setString(2, courseCode);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
