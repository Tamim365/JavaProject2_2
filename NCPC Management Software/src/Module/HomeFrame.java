package Module;


import javax.swing.*;
import Object.ParticipantInfo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class HomeFrame extends javax.swing.JFrame {

    /**
     * Creates new form HomeFrame
     */
    public HomeFrame() {
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("NCPC - National Collegiate Programming Contest");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent evt) {
                try
                {
                    int opt = JOptionPane.showConfirmDialog(null, "Do you want to Exit?","Close",JOptionPane.YES_NO_OPTION);
                    if(opt == 0) System.exit(0);
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Oops! There are some problems!", "Unknown Error Occured!", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eventDetailsButtonTwo = new javax.swing.JLabel();
        logInButton = new javax.swing.JLabel();
        registrationButton = new javax.swing.JLabel();
        rulesButton = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        homeBackgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        eventDetailsButtonTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/eventDetailsButton_1.png"))); // NOI18N
        eventDetailsButtonTwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventDetailsButtonTwoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eventDetailsButtonTwoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eventDetailsButtonTwoMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eventDetailsButtonTwoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                eventDetailsButtonTwoMouseReleased(evt);
            }
        });
        getContentPane().add(eventDetailsButtonTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 330, -1, -1));

        logInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/logInButton_1.png"))); // NOI18N
        logInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logInButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logInButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logInButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logInButtonMouseReleased(evt);
            }
        });
        getContentPane().add(logInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, -1, -1));

        registrationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/registrationButton_1.png"))); // NOI18N
        registrationButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrationButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrationButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrationButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registrationButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                registrationButtonMouseReleased(evt);
            }
        });
        getContentPane().add(registrationButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 260, -1, -1));

        rulesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/rulesButton_1.png"))); // NOI18N
        rulesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rulesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rulesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rulesButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rulesButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rulesButtonMouseReleased(evt);
            }
        });
        getContentPane().add(rulesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 400, -1, 62));

        exitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/exitButton_1.png"))); // NOI18N
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButtonMouseReleased(evt);
            }
        });
        getContentPane().add(exitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 480, -1, -1));

        homeBackgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/homeBackground.png"))); // NOI18N
        getContentPane().add(homeBackgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventDetailsButtonTwoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventDetailsButtonTwoMouseEntered
      
        eventDetailsButtonTwo.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/eventDetailsButton_2.png")));
    }//GEN-LAST:event_eventDetailsButtonTwoMouseEntered

    private void eventDetailsButtonTwoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventDetailsButtonTwoMouseExited
        
        eventDetailsButtonTwo.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/eventDetailsButton_1.png")));
    }//GEN-LAST:event_eventDetailsButtonTwoMouseExited

    private void eventDetailsButtonTwoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventDetailsButtonTwoMousePressed
      
        eventDetailsButtonTwo.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/eventDetailsButton_3.png")));
    }//GEN-LAST:event_eventDetailsButtonTwoMousePressed

    private void eventDetailsButtonTwoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventDetailsButtonTwoMouseReleased
       
        eventDetailsButtonTwo.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/eventDetailsButton_2.png")));
    }//GEN-LAST:event_eventDetailsButtonTwoMouseReleased

    private void logInButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseEntered
       
        logInButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/logInButton_2.png")));
    }//GEN-LAST:event_logInButtonMouseEntered

    private void logInButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMousePressed
        
        logInButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/logInButton_3.png")));
    }//GEN-LAST:event_logInButtonMousePressed

    private void logInButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseExited
       
        logInButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/logInButton_1.png")));
    }//GEN-LAST:event_logInButtonMouseExited

    private void logInButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseReleased
        
        logInButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/logInButton_2.png")));
    }//GEN-LAST:event_logInButtonMouseReleased

    private void registrationButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMouseEntered
        registrationButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/registrationButton_2.png")));
    }//GEN-LAST:event_registrationButtonMouseEntered

    private void registrationButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMouseExited
        registrationButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/registrationButton_1.png")));
    }//GEN-LAST:event_registrationButtonMouseExited

    private void registrationButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMousePressed
       registrationButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/registrationButton_3.png")));
    }//GEN-LAST:event_registrationButtonMousePressed

    private void registrationButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMouseReleased
       registrationButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/registrationButton_2.png")));
    }//GEN-LAST:event_registrationButtonMouseReleased

    private void rulesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMouseEntered
        // TODO add your handling code here:
        rulesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/rulesButton_2.png")));
    }//GEN-LAST:event_rulesButtonMouseEntered

    private void rulesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMouseExited
        // TODO add your handling code here:
         rulesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/rulesButton_1.png")));
    }//GEN-LAST:event_rulesButtonMouseExited

    private void rulesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMousePressed
        // TODO add your handling code here:
         rulesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/rulesButton_3.png")));
    }//GEN-LAST:event_rulesButtonMousePressed

    private void rulesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMouseReleased
        // TODO add your handling code here:
         rulesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/rulesButton_2.png")));
    }//GEN-LAST:event_rulesButtonMouseReleased

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        // TODO add your handling code here:
         exitButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/exitButton_2.png")));
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        // TODO add your handling code here:
        exitButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/exitButton_1.png")));
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMousePressed
        // TODO add your handling code here:
        exitButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/exitButton_3.png")));
    }//GEN-LAST:event_exitButtonMousePressed

    private void exitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseReleased
        // TODO add your handling code here:
        exitButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/exitButton_2.png")));
        
    }//GEN-LAST:event_exitButtonMouseReleased

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Do you want to Exit?","Close",JOptionPane.YES_NO_OPTION);
        if(opt == 0) System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void registrationButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrationButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        RegistrationFrame rg = new RegistrationFrame();
        rg.setVisible(true);
        ParticipantInfo pt = new ParticipantInfo();
        System.out.println(pt.find("tamim365"));
    }//GEN-LAST:event_registrationButtonMouseClicked

    private void logInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        LoginFrame lg = new LoginFrame();
        lg.setVisible(true);
    }//GEN-LAST:event_logInButtonMouseClicked

    private void eventDetailsButtonTwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventDetailsButtonTwoMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        EventDetailsFrame ed = new EventDetailsFrame();
        ed.setVisible(true);
    }//GEN-LAST:event_eventDetailsButtonTwoMouseClicked

    private void rulesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rulesButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        RulesFrame rf = new RulesFrame();
        rf.setVisible(true);
    }//GEN-LAST:event_rulesButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel eventDetailsButtonTwo;
    private javax.swing.JLabel exitButton;
    private javax.swing.JLabel homeBackgroundLabel;
    private javax.swing.JLabel logInButton;
    private javax.swing.JLabel registrationButton;
    private javax.swing.JLabel rulesButton;
    // End of variables declaration//GEN-END:variables
}
