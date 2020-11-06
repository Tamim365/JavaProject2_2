/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class TeamInfo {
    public HashMap<String, Team> allInfo;
    
    ///retrieve data from file
    public TeamInfo()
    {
        allInfo = new HashMap<String, Team>();
        readData();
    }
    
    ///retrieve data from program
    public TeamInfo(HashMap<String, Team> Info)
    {
        allInfo = new HashMap<String, Team>();
        allInfo.putAll(Info);
    }
    
    synchronized public void readData()
    {
        String file = "src/data/team/team.txt";
        try {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                allInfo = (HashMap<String, Team>) ois.readObject();
                System.out.println("Team READ DONE.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Team Unable to read!");
                e.printStackTrace();
            }
            finally{
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Team Unable To Close FIS!");
                } finally{
                    try {
                        ois.close();
                    } catch (Exception e) {
                        System.out.println("Team Unable To Close OIS!");
                    }
                    
                }
            }
            
        } catch (Exception e) {
             System.out.println("Team Failed to load");
        }
    }
    
    synchronized public void writeData() throws IOException, ClassNotFoundException, Exception {
        String file = "src/data/team/team.txt";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(allInfo);
        oos.close();
        fos.close();
        System.out.println("Team Write Done!");
    }
    
    public void add(Team team){
        allInfo.put(team.getId(), team);
    }
    
    public boolean isValid(String id){
        return allInfo.containsKey(id);
    }
    
    public Team find(String id) {
        return allInfo.get(id);
    }
    
    public void delete(String id) {
        allInfo.remove(id);
    }
    
    public void update(Team team) {
        delete(team.getId());
        add(team);
    }
    public String toString(){
        String st = new String("");
        Iterator it = allInfo.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry obj = (Map.Entry)it.next();
            System.out.println(obj.getValue());
            st += obj.getValue().toString() + '\n';
         }
        return st;
    }
}
