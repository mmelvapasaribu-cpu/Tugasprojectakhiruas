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
import model.lecture;
/**
 *
 * @author ASUS
 */
public class lectureDao {
    private Connection connection;

    public lectureDao() {
        connection = DBConnection.getConnection();
    }

    public int create(lecture lecture) {
        try {
            String sql = "INSERT INTO lecturers (NIDN, name, faculty) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecture.getNidn());
            stmt.setString(2, lecture.getName());
            stmt.setString(3, lecture.getExpertise());
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<lecture> getAll() {
        List<lecture> lectureList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM lecturers";
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String idCard = rs.getString("idCard");
                String nidn = rs.getString("NIDN");
                String name = rs.getString("name");
                String faculty = rs.getString("faculty");

                lectureList.add(new lecture(idCard,nidn, name, faculty));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lectureList;
    }

    public int update(lecture lecture, String nidn) {
        try {
            String sql = "UPDATE lecturers SET name=?, faculty=? WHERE NIDN=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, lecture.getName());
            stmt.setString(2, lecture.getExpertise());
            stmt.setString(3, nidn);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(String nidn) {
        try {
            String sql = "DELETE FROM lecturers WHERE NIDN=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nidn);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
