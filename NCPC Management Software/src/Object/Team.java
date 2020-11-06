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
    public String teamName;
    public String university;
    public String coahEmail;
    public String teamId;
    public String coachName;
    public String member1;
    public String member2;
    public String member3;
    public boolean paymentStatus;
    
    public Team(String teamName, String university, String coachName, String coachEmail, String member1, String member2, String member3, String teamId) {
        this.teamName = teamName;
        this.university = university;
        this.coachName = coachName;
        this.coahEmail = coachEmail;
        this.teamId = teamId;
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
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
