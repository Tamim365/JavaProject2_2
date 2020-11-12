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
public class WrongNumberException extends Exception{
    
    public WrongNumberException(String number)
    {
        super(number + " Format is Not Right");
        JOptionPane.showMessageDialog(null, "Contact Number Format is Not Right ", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
