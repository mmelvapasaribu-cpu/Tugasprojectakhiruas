/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import model.Course;

/**
 *
 * @author ASUS
 */
import model.Course;
import model.Student;

public class KRS {
    private Student student;
    private Course Course;
    private double score;
    private String grade;
    private lecture lecturel;
    private int semester;
    
    public KRS (Student student, Course course, double score){
    this.student = student;    
    this.Course = course;
    this.score = score;
    this.grade = setGrade();
    }
    public KRS(Course course, double score) {
    this.Course = course;
    this.score = score;
    this.grade = setGrade();
}
    public KRS(Student student, Course course, int semester) {
    this.student = student;
    this.Course = course;
    this.semester = semester;
}
    public void setLecturer (lecture lecturer){
    this.lecturel = lecturer;
    }
    public void setSemester (int semester){
    this.semester = semester;
    }
    public int getSemester() {
    return semester;
}
    public lecture getLecturer(){
    return lecturel;
    }
    public Student getStudent(){
    return student;
    }
    public Course getCourse(){
    return Course;
    }
    public double getScore(){
    return score;
    }
    public String getGrade(){
    return grade;
    }
    private String setGrade(){
    if (score >=85)
        return "A";
    else if (score >= 75)
        return "B";
    else if (score >= 60)
        return "C";
                else
        return "D";
    }
    
}


