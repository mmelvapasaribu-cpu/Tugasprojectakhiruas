/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class person {
    
    protected String idCard;
    protected String name;
    public person (String idCard, String name){
    this.idCard=idCard;
    this.name=name;
    }
    public String getIdCard(){
    return idCard;
    }
    public String getName(){
    return name;
    }
}
