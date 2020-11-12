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
public class TextLengthLimitExceededdException extends Exception{
    
    public TextLengthLimitExceededdException(String text)
    {
        super(text + " Length Exceeds Limit");
        JOptionPane.showMessageDialog(null, "Maximum Length Limit Exceeded", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
