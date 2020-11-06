/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Object;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class Team implements Serializable{
    ArrayList<String> members;
    
    public String teamName;
    public String university;
    public String coahEmail;
    public String teamId;
    public String coachName;
    public boolean paymentStatus;
    
    public Team(ArrayList<String> getMem, String teamName, String university, String coachName, String coachEmail, String teamId) {
        members = new ArrayList<String>();
        members.addAll(getMem);
        this.teamName = teamName;
        this.university = university;
        this.coahEmail = coachEmail;
        this.teamId = teamId;
        this.paymentStatus = false;
    }
    
    public String getId(){
        return teamId;
    }
    
    public String toString(){
        String st = new String("Team: " + teamName + "\nTeam Id: " + teamId + "\nUniversity: " + university + "\nCoach: " + coachName);
        return st;
    }
}
