/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.Arraylist;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import config.DBConnection;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author ASUS
 */
public class StudentDAO {
    private Connection connection;
    public StudentDAO() {
        connection = DBConnection.getConnection();
    }
    
    public int create(Student student){
        try {
            String sql = "INSERT INTO students (cardID, NIM, name, studyProgram) VALUES(?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getNim());
            stmt.setString(3, student.getName());
            stmt.setString(4, student.getStudyProgram());
            stmt.executeUpdate();
            return 1;
        }catch (SQLException e){
        return 0;
        }
    }
    public List<Student> getStudent(){
        List<Student> student = new ArrayList<>();
        try {
            String sql = " SELECT * FROM students";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("StudentID");
                String cardID = rs.getString("cardID");
                String NIM = rs.getString("NIM");
                String name = rs.getString("name");
                String studiProgram = rs.getString("studyProgram");
                
                student.add(new Student (cardID,name,NIM,studiProgram));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return student;
    }
    
    public int update(Student student, String nim){
        try {
            String sql = "UPDATE students SET cardID=?, name=?, studyProgram=? WHERE NIM=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, student.getCardID());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getStudyProgram());
            stmt.setString(4, nim);
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            return 0;
        }
    } 
    
    public int delete(String nim){
        try{
            String sql = "DELETE FROM students WHERE NIM=?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nim);
            stmt.executeUpdate();
            return 1;
        }catch(SQLException e){
            return 0;
        }
    }

    List<Student> getStrudent() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}