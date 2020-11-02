/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Object;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * 
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class ParticipantInfo {
    public HashMap<String, Participant> allInfo;
    
    public ParticipantInfo() {
        allInfo = new HashMap<String, Participant>();
        readData();
    }
    
    public ParticipantInfo(HashMap<String, Participant> Info){
        allInfo = new HashMap<String, Participant>();
        allInfo.putAll(Info);
    }
    

    synchronized public void readData() {
        String file = "src/data/participant/participants.txt";
        try {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            allInfo = (HashMap<String, Participant>) ois.readObject();
            System.out.println("Read Done!");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Unable to read!");
                e.printStackTrace();
            }
            finally{
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Unable to close FIS!");
                } finally{
                    try {
                        ois.close();
                    } catch (Exception e) {
                        System.out.println("Unable to close OIS!");
                    }
                    
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load");
        }
    }

    synchronized public void writeData() throws IOException, ClassNotFoundException, Exception {
        String file = "src/data/participant/participants.txt";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(allInfo);
        oos.close();
        fos.close();
        System.out.println("Write Done!");
    }
    
    public void add(Participant obj){
        allInfo.put(obj.getId(), obj);
    }
    
    public boolean isValid(String id){
        return allInfo.containsKey(id);
    }
    
    public Participant find(String id) {
        return allInfo.get(id);
    }
    
    public boolean match(String id, String pass) {
        return find(id).match(pass);
    }
    
    public void delete(String id) {
        allInfo.remove(id);
    }
    
    public void update(Participant Obj) {
        delete(Obj.getId());
        add(Obj);
    }
}
