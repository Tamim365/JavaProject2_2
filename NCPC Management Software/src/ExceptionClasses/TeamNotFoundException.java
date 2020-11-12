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
public class TeamNotFoundException extends Exception{
    
    public TeamNotFoundException(String team)
    {
        super(team + "Not Found");
        JOptionPane.showMessageDialog(null, "Team Not Found", "Wrong", JOptionPane.ERROR_MESSAGE);
    }
    
}
