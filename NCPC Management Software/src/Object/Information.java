/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public interface Information {
    public void readData() throws Exception;
    public void writeData() throws Exception;
    public <T> T find(String id);
    public void delete(String id);
}
