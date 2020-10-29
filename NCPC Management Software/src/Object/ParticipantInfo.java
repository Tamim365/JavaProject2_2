/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    

    public void readData() {
        String file = "src/data/participant/participants.txt";
        try {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        allInfo = (HashMap<String, Participant>) ois.readObject();
        }
        catch (Exception e) {
            System.out.println("End of file!");
        }
    }

    public void writeData() throws Exception {
        String file = "src/data/participant/participants.txt";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(allInfo);
        oos.close();
        fos.close();
    }
    
    public void add(Participant obj){
        allInfo.put(obj.getId(), obj);
    }
    
    public Participant find(String id) {
        return allInfo.get(id);
    }

    public void delete(String id) {
        allInfo.remove(id);
    }
    
    public void update(Participant Obj) {
        delete(Obj.getId());
        add(Obj);
    }
}
