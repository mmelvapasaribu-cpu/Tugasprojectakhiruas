/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */

public class Course {
    private String Code;
    private String courseName;
    private int sks;
    private int semester;
    
    public Course (String code,
            String courseName,
            int sks,
            int semester){
    
    this.Code = code;
    this.courseName=courseName;
    this.sks=sks;
    this.semester=semester;
  }
    public String toString(){
    return this.courseName;
    }
public String getCode(){
return Code;
}
public String getCourseName(){
return courseName;
}
public int getSKS(){
return sks;
}
}