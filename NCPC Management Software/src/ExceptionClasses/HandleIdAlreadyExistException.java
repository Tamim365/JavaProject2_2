/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExceptionClasses;

import javax.swing.JOptionPane;

/**
 *
 * @author Shiary29 <shiaryk29 at gmail.com>
 */
public class HandleIdAlreadyExistException extends Exception{
    
    public HandleIdAlreadyExistException(String Id)
    {
        super(Id + " Already Exist");
        JOptionPane.showMessageDialog(null, "Handle Id Already Exist", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
