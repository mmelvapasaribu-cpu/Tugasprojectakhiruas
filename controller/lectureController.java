/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.lectureDao;
import java.util.List;
import model.lecture;
/**
 *
 * @author ASUS
 */
public class lectureController {
    private lectureDao lectureDAO = new lectureDao();

    public List<lecture> getAll() {
        return lectureDAO.getAll();
    }

    public int create(lecture lecture) {
        return lectureDAO.create(lecture);
    }

    public int update(lecture lecture, String nidn) {
        return lectureDAO.update(lecture, nidn);
    }

    public int delete(String nidn) {
        return lectureDAO.delete(nidn);
    }
}
