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
public class WrongPasswordException extends Exception{
    
    public WrongPasswordException (String pass)
    {
        super(pass + "Is Wrong");
        JOptionPane.showMessageDialog(null, "Password is Wrong", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
