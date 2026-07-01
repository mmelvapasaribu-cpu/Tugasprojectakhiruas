/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class lecture extends person {
    private String nind;
    private String expertise;
    public lecture (String idCard,
            String name,
            String nind,
            String expertise){
    super (idCard, name);
    
    this.nind = nind;
    this.expertise = expertise;
    
    }
     public String getExpertise() {
        return expertise;
    }
     public String getNidn() {
    return nind;
}
    public String toString(){
    return this.name;
    }
}
