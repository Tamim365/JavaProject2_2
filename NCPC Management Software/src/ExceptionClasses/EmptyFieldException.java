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
public class EmptyFieldException extends Exception{
    
    public EmptyFieldException(String input)
    {
        super(input + " Text Field Is Empty");
        JOptionPane.showMessageDialog(null, "Text Field Is Empty", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
