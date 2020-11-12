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
public class WrongEmailException extends Exception{
    
    public WrongEmailException(String mail)
    {
        super(mail + " Format is Not Right");
        JOptionPane.showMessageDialog(null, "Email Format is Not Right", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
