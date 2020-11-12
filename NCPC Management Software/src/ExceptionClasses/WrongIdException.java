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
public class WrongIdException extends Exception{
    
    public WrongIdException(String id)
    {
        super(id + "Is Wrong");
        JOptionPane.showMessageDialog(null, "Handle Id is Wrong", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
