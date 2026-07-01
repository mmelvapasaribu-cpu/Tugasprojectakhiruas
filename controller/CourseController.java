
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.CourseDao;
import java.util.List;
import model.Course;

/**
 *
 * @author User
 */
public class CourseController {
    private CourseDao courseDAO = new CourseDao();
    public List<Course>getAll(){
        return courseDAO.getAll();
    }
}

