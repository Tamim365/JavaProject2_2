package Module;


import ExceptionClasses.HandleIdNotFoundException;
import Module.HomeFrame;
import Module.ParticipantModule;
import Object.Coach;
import Object.CoachInfo;
import Object.Participant;
import Object.ParticipantInfo;
import Object.Team;
import Object.TeamInfo;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shiary29 <shiaryk29 at gmail.com>
 */
public class LoginFrame extends javax.swing.JFrame {

    HashMap<String, Participant> allParticipantInfo;
    HashMap<String, Coach> allCoachInfo;
    HashMap<String, Team> allTeamInfo;
    
    public LoginFrame() {
        setupFrame();
    }
    public LoginFrame(HashMap<String, Participant> PartInfo , HashMap<String, Coach> CoachInfo, HashMap<String, Team> teamInfo){
        allParticipantInfo = new HashMap<String, Participant>();
        allParticipantInfo.putAll(PartInfo);
        
        allCoachInfo= new HashMap<String, Coach> ();
        allCoachInfo.putAll(CoachInfo);
        
        allTeamInfo = new HashMap<String, Team>();
        allTeamInfo.putAll(teamInfo);
        
        setupFrame();
    }

    public void setupFrame(){
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Login");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent evt) {
                try
                {
                    int opt = JOptionPane.showConfirmDialog(null, "Do you want to Exit?","Close",JOptionPane.YES_NO_OPTION);
                    if(opt == 0) {
                        ParticipantInfo PI = new ParticipantInfo(allParticipantInfo);
                        PI.writeData();
                        
                        CoachInfo ci = new CoachInfo(allCoachInfo);
                        ci.writeData();
                        System.exit(0);
                    }
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        adminButton = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        participantLoginTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        partLoginBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        partLoginPasswordField = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        coachLoginBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        coachLoginTextField = new javax.swing.JTextField();
        coachLoginPasswordField = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        adminLoginBtn = new javax.swing.JButton();
        adminLoginTextField = new javax.swing.JTextField();
        adminLoginPasswordField = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/participantButton_1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/coachButton_1.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel2MouseReleased(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/backButton_1.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, -1, -1));

        adminButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/administratorButton_1.png"))); // NOI18N
        adminButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adminButtonMouseReleased(evt);
            }
        });
        getContentPane().add(adminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, -1, -1));

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/participantBanner.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 440, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Handle ID/Email  :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 200, 40));

        participantLoginTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        participantLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantLoginTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(participantLoginTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 450, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Forgot password?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 200, 40));

        partLoginBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        partLoginBtn.setText("Login");
        partLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partLoginBtnActionPerformed(evt);
            }
        });
        jPanel1.add(partLoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 130, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password            :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 200, 40));

        partLoginPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(partLoginPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 450, 40));

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/coachBanner.png"))); // NOI18N
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 90));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email                  :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 200, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password            :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 200, 40));

        coachLoginBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        coachLoginBtn.setText("Login");
        coachLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLoginBtnActionPerformed(evt);
            }
        });
        jPanel2.add(coachLoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 130, 50));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Forgot password?");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 200, 40));

        coachLoginTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        coachLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachLoginTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(coachLoginTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 450, 40));

        coachLoginPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(coachLoginPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 450, 40));

        jTabbedPane1.addTab("tab2", jPanel2);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/adminBanner.png"))); // NOI18N
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, 90));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("User ID               :");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 200, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Password            :");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 200, 40));

        adminLoginBtn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        adminLoginBtn.setText("Login");
        jPanel3.add(adminLoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 420, 130, 50));

        adminLoginTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        adminLoginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(adminLoginTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 450, 40));

        adminLoginPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(adminLoginPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 450, 40));

        jTabbedPane1.addTab("tab2", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, -30, 990, 800));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/loginRegistrationBackground.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/participantButton_2.png")));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/participantButton_1.png")));
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        // TODO add your handling code here:
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/participantButton_3.png")));
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
        // TODO add your handling code here:
        jLabel1.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/participantButton_2.png")));
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/coachButton_2.png")));
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/coachButton_1.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        // TODO add your handling code here:
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/coachButton_3.png")));
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseReleased
        // TODO add your handling code here:
        jLabel2.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/coachButton_2.png")));
    }//GEN-LAST:event_jLabel2MouseReleased

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        HomeFrame home = new HomeFrame(allParticipantInfo , allCoachInfo, allTeamInfo);
        home.setVisible(true);
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        // TODO add your handling code here:
        backButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backButton_2.png")));
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        // TODO add your handling code here:
        backButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backButton_1.png")));
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMousePressed
        // TODO add your handling code here:
        backButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backButton_3.png")));
    }//GEN-LAST:event_backButtonMousePressed

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        // TODO add your handling code here:
        backButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backButton_2.png")));
    }//GEN-LAST:event_backButtonMouseReleased

    private void adminButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminButtonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_adminButtonMouseClicked

    private void adminButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminButtonMouseEntered
        // TODO add your handling code here:
        adminButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/administratorButton_2.png")));
    }//GEN-LAST:event_adminButtonMouseEntered

    private void adminButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminButtonMouseExited
        // TODO add your handling code here:
        adminButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/administratorButton_1.png")));
    }//GEN-LAST:event_adminButtonMouseExited

    private void adminButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminButtonMousePressed
        // TODO add your handling code here:
        adminButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/administratorButton_3.png")));
    }//GEN-LAST:event_adminButtonMousePressed

    private void adminButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminButtonMouseReleased
        // TODO add your handling code here:
        adminButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/administratorButton_2.png")));
    }//GEN-LAST:event_adminButtonMouseReleased

    private void participantLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantLoginTextFieldActionPerformed

    private void coachLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachLoginTextFieldActionPerformed

    private void adminLoginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminLoginTextFieldActionPerformed

    private void partLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partLoginBtnActionPerformed
        // TODO add your handling code here:
        String id = participantLoginTextField.getText().toString();
        String password = new String(partLoginPasswordField.getPassword());
        ParticipantInfo PI = new ParticipantInfo(allParticipantInfo);
        if(PI.isValid(id) && PI.match(id, password)){
            //JOptionPane.showMessageDialog(null, "Login Successful");
            this.setVisible(false);
            ParticipantModule PM = new ParticipantModule(allParticipantInfo, PI.find(id) , allCoachInfo, allTeamInfo);
            PM.setVisible(true);
        }
        else{
//            try{
//               throw new HandleIdNotFoundException(id);
//            }
//            catch(HandleIdNotFoundException ex)
//            {
//                System.out.println(ex);
//            }
            JOptionPane.showMessageDialog(null, "Invaild Id or Password", "Wrong", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_partLoginBtnActionPerformed

    private void coachLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachLoginBtnActionPerformed
        // TODO add your handling code here:
        String email = coachLoginTextField.getText().toString();
        String password = new String(coachLoginPasswordField.getPassword());
        CoachInfo CI = new CoachInfo(allCoachInfo);
        if(CI.isValid(email) && CI.match(email, password)){
            //JOptionPane.showMessageDialog(null, "Login Successful");
            this.setVisible(false);
            TeamInfo TI = new TeamInfo(allTeamInfo);
            //System.out.println(TI);
            //System.out.println("Helllllllooooooo");
            CoachModule CM = new CoachModule(allParticipantInfo, CI.find(email) , allCoachInfo, allTeamInfo);
            //System.out.println("Helllllllooooooo2222222");
            CM.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Invaild Id or Password", "Wrong", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_coachLoginBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adminButton;
    private javax.swing.JButton adminLoginBtn;
    private javax.swing.JPasswordField adminLoginPasswordField;
    private javax.swing.JTextField adminLoginTextField;
    private javax.swing.JLabel backButton;
    private javax.swing.JButton coachLoginBtn;
    private javax.swing.JPasswordField coachLoginPasswordField;
    private javax.swing.JTextField coachLoginTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton partLoginBtn;
    private javax.swing.JPasswordField partLoginPasswordField;
    private javax.swing.JTextField participantLoginTextField;
    // End of variables declaration//GEN-END:variables
}
