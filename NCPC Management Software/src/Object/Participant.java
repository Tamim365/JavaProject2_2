
package Object;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class Participant implements Serializable{
    public String name;
    public String email;
    public String handleId;
    public String mobile;
    public String university;
    public String dateOfBirth;
    public String gender;
    public String tShirt;
    public String presentAddress;
    public String password;
    public String teamId;
    public String coachName;
    public String coachEmail;
    public ArrayList<String[]> messages;
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
        this.teamId = "null";
        this.coachEmail = "null";
        this.coachName = "null";
        String[] st = {"null", "null"};
        messages = new ArrayList<String[]>();
        messages.add(st);
        
    }
    public String getId(){
        return handleId;
    }
    public String getName(){
        return name;
    }
    public boolean match(String pass){
        return this.password.equals(pass);
    }
    public void addMessage(String sub, String msg) {
        String[] messageStr = {coachName, sub, msg};
        messages.add(messageStr);
    }
    public String toString(){
        String st = new String("Name: " + name + "\nhandleID: " + handleId + "\nUniversity: " + university + "\nEmail: " + email);
        return st;
    }
}
