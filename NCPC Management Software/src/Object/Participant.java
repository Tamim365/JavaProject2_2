/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Object;

import java.io.Serializable;

/**
 * 
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class Participant implements Serializable{
    private String name;
    private String email;
    private String handleId;
    private String mobile;
    private String university;
    private String dateOfBirth;
    private String gender;
    private String tShirt;
    private String presentAddress;
    private String password;
    public Participant(){}
    public Participant(
        String name,
        String email,
        String handleId,
        String mobile,
        String university,
        String dateOfBirth,
        String gender,
        String tShirt,
        String presentAddress,
        String password){
        this.name = name;
        this.email = email;
        this.handleId = handleId;
        this.mobile = mobile;
        this.university = university;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.tShirt = tShirt;
        this.presentAddress = presentAddress;
        this.password = password;
    }
    public String getId(){
        return handleId;
    }
    public boolean match(String pass){
        return this.password.equals(pass);
    }
    public String toString(){
        String st = new String("Name: " + name + "\nhandleID: " + handleId + "\nUniversity: " + university + "\nEmail: " + email);
        return st;
    }
}
