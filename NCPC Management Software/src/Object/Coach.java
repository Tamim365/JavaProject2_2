
package Object;

import java.io.Serializable;

/**
 *
 * @author Shiary29 <shiaryk29 at gmail.com>
 */
public class Coach implements Serializable{
    public String name;
    public String email;
    public String mobile;
    public String university;
    public String position;
    public String dateOfBirth;
    public String gender;
    public String presentAddress;
    public String password;
    public String tShirt;
    
    public Coach(){}
    
    public Coach(
        String name,
        String email,
        String mobile,
        String university,
        String position,
        String dateOfBirth,
        String gender,
        String tShirt,
        String presentAddress,
        String password
    )
    {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.university = university;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.tShirt = tShirt;
        this.presentAddress = presentAddress;
        this.password = password;
    }
    public String getId(){
        return email;
    }
     public boolean match(String pass){
        return this.password.equals(pass);
    }
     
    public String toString(){
        String st = new String("Coach Name: " + name + "\nCoach email: " + email + "\nCoach University: " + university + "\nCoachgender " + gender);
        return st;
    }
}
