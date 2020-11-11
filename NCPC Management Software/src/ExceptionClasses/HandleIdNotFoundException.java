/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ExceptionClasses;

import javax.swing.JOptionPane;

/**
 * 
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class HandleIdNotFoundException extends Exception{
    public HandleIdNotFoundException(String Id)
    {
        super(Id + " Not Found");
        JOptionPane.showMessageDialog(null, "Invaild Id or Password", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
}
