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
public class InvalidInputException extends Exception{
    
    public InvalidInputException(String input)
    {
        super(input + " Not Valid");
        JOptionPane.showMessageDialog(null, "Input is Not Valid", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
