/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.KRSDao;
import java.util.List;
import model.KRS;

/**
 *
 * @author ASUS
 */
public class KRSController {
    private KRSDao krsDAO = new KRSDao();

    public List<KRS> getAll() {
        return krsDAO.getAll();
    }

    public List<KRS> getByNim(String nim) {
        return krsDAO.getByNim(nim);
    }

    public int create(KRS krs) {
        return krsDAO.create(krs);
    }

    public int update(KRS krs, String nim, String oldCourseCode) {
        return krsDAO.update(krs, nim, oldCourseCode);
    }

    public int delete(String nim, String courseCode) {
        return krsDAO.delete(nim, courseCode);
    }
    
}
