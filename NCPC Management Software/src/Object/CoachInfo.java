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
 * @author Shiary29 <shiaryk29 at gmail.com>
 */
public class CoachInfo {
    public HashMap<String, Coach> allInfo;
    
    ///retrieve data from file
    public CoachInfo()
    {
        allInfo = new HashMap<String, Coach>();
        readData();
    }
    
    ///retrieve data from program
    public CoachInfo(HashMap<String, Coach> Info)
    {
        allInfo = new HashMap<String, Coach>();
        allInfo.putAll(Info);
    }
    
    synchronized public void readData()
    {
        String file = "src/data/coach/coach.txt";
        try {
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                allInfo = (HashMap<String, Coach>) ois.readObject();
                System.out.println("Coach READ DONE.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Coach Unable to read!");
                e.printStackTrace();
            }
            finally{
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Coach Unable To Close FIS!");
                } finally{
                    try {
                        ois.close();
                    } catch (Exception e) {
                        System.out.println("Coach Unable To Close OIS!");
                    }
                    
                }
            }
            
        } catch (Exception e) {
             System.out.println("Coach Failed to load");
        }
    }
    
    synchronized public void writeData() throws IOException, ClassNotFoundException, Exception {
        String file = "src/data/coach/coach.txt";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(allInfo);
        oos.close();
        fos.close();
        System.out.println("Coach Write Done!");
    }
    
    
    public void add(Coach c){
        allInfo.put(c.getId(), c);
    }
    
    public boolean isValid(String id){
        return allInfo.containsKey(id);
    }
    
    public Coach find(String id) {
        return allInfo.get(id);
    }
    
    public boolean match(String id, String pass) {
        return find(id).match(pass);
    }
    
    public void delete(String id) {
        allInfo.remove(id);
    }
    
    public void update(Coach c) {
        delete(c.getId());
        add(c);
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
