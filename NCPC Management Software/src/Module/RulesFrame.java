package Module;


import Object.Coach;
import Object.CoachInfo;
import Object.Participant;
import Object.ParticipantInfo;
import Object.Team;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
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
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class RulesFrame extends javax.swing.JFrame {
    
    
    
    HashMap<String, Participant> allParticipantInfo;
    HashMap<String, Coach> allCoachInfo;
    HashMap<String, Team> allTeamInfo;
    
    
    public RulesFrame()
    {
        setupFrame();
    }
    
    public RulesFrame(HashMap<String, Participant> PartInfo , HashMap<String, Coach> CoachInfo, HashMap<String, Team> teamInfo){
        allParticipantInfo = new HashMap<String, Participant>();
        allParticipantInfo.putAll(PartInfo);
        
        allCoachInfo= new HashMap<String, Coach> ();
        allCoachInfo.putAll(CoachInfo);
        
        allTeamInfo = new HashMap<String, Team>();
        allTeamInfo.putAll(teamInfo);
        
        setupFrame();
    }

    public void setupFrame() {
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Rules");
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent evt) {
                try
                {
                    int opt = JOptionPane.showConfirmDialog(null, "Do you want to Exit?","Close",JOptionPane.YES_NO_OPTION);
                    if(opt == 0) System.exit(0);
                {
                        ParticipantInfo PI = new ParticipantInfo(allParticipantInfo);
                        PI.writeData();
                        System.exit(0);
                        
                        ///added
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("RULES FOR NCPC 2021");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 24, 532, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 204, 255));
        jLabel3.setText("1.Team Requirements");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, 488, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 204, 255));
        jLabel4.setText("6.Computing Environment");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 567, 488, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 204, 255));
        jLabel6.setText("4.Conduct of the Finals");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 488, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 204, 255));
        jLabel9.setText("2.Attendance");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 215, 251, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 204, 255));
        jLabel11.setText("3.Support and Prizes");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 312, 383, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 204, 255));
        jLabel12.setText("5.Scoring of the Finals ");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 482, 449, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 204, 255));
        jLabel13.setText("7.Contestant Conduct ");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 652, 512, -1));

        jLabel5.setForeground(new java.awt.Color(255, 204, 204));
        jLabel5.setText("Teams qualify to advance to the World Finals through Regional Contests. No team member on the qualifying team may have competed as a contestant in two previous World Finals.");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 161, 1247, -1));

        jLabel7.setForeground(new java.awt.Color(255, 204, 204));
        jLabel7.setText("The coach of a qualifying team is the point-of-contact before and during World Finals activities.All team members who are attending the team’s institution on visas must have permission to ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 188, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("Finalists must attend all required events from On-Site Registration to Celebration as indicated in the Schedule of Events.  Failure to attend any required event will result in disqualification and ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 246, 1275, -1));

        jLabel10.setForeground(new java.awt.Color(255, 204, 204));
        jLabel10.setText("forfeiture of scholarships and prizes.  Coaches must be accessible during On-Site Registration, Dress Rehearsal, the World Finals, and the Closing Ceremony.  ");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 273, 1275, -1));

        jLabel15.setForeground(new java.awt.Color(255, 204, 204));
        jLabel15.setText("gender privacy.  The teams and coaches will be treated to a full schedule of activities including a full course of complimentary food functions. Transportation to the  World Finals  is");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 1249, -1));

        jLabel18.setForeground(new java.awt.Color(255, 204, 204));
        jLabel18.setText("Ten or more problems have been posed in recent World Finals.Problems will be posed in English. During the contest, all communications from contest officials to contestants will be in ");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 428, 1276, -1));

        jLabel19.setForeground(new java.awt.Color(255, 204, 204));
        jLabel19.setText("English. Each team may identify an interpreter for translating questions posed by contestants to contest officials. Contestants may bring electronic natural language translators provided");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 455, 1276, -1));

        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("The World Finals Judges are solely responsible for determining the correctness of submitted runs. In consultation with the World Finals Judges, the Director of Judging is responsible");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 513, 1275, -1));

        jLabel22.setForeground(new java.awt.Color(255, 204, 204));
        jLabel22.setText("for determining the winners of the World Finals. The total time is the sum of the time consumed for each problem solved. ");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 540, 1275, -1));

        jLabel23.setForeground(new java.awt.Color(255, 204, 204));
        jLabel23.setText("The World Finals programming language tools include Java, C, C++, Kotlin and Python.  See the Programming Environment Web Site for detailed configuration information.");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 598, 1275, -1));

        jLabel24.setForeground(new java.awt.Color(255, 204, 204));
        jLabel24.setText("  Before the World Finals, the judges will have solved all problems in languages from at least two of the three distinct language groups (Java/Kotlin, C/C++, and Python).");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 625, 1275, -1));

        jLabel26.setForeground(new java.awt.Color(255, 204, 204));
        jLabel26.setText("DO NOT TOUCH ANYTHING at the team workstations until so directed by the Finals Director.");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 683, 1277, -1));

        jLabel14.setForeground(new java.awt.Color(255, 204, 204));
        jLabel14.setText("Each finalist team will be provided with hotel accommodations for the coach and three contestants according to dates published on ICPC Invitations. The hotel accommodations will provide");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 343, -1, -1));

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/home/backBtnSmall_1.png"))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backBtnMouseReleased(evt);
            }
        });
        getContentPane().add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 680, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 204, 204));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/rules_eventDetailsBG.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        HomeFrame home = new HomeFrame(allParticipantInfo , allCoachInfo, allTeamInfo);
        home.setVisible(true);
    }//GEN-LAST:event_backBtnMouseClicked

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        // TODO add your handling code here:
        backBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backBtnSmall_2.png")));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        // TODO add your handling code here:
        backBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backBtnSmall_1.png")));
    }//GEN-LAST:event_backBtnMouseExited

    private void backBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMousePressed
        // TODO add your handling code here:
        backBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backBtnSmall_3.png")));
    }//GEN-LAST:event_backBtnMousePressed

    private void backBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseReleased
        // TODO add your handling code here:
        backBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/home/backBtnSmall_2.png")));
    }//GEN-LAST:event_backBtnMouseReleased

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
            java.util.logging.Logger.getLogger(RulesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RulesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RulesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RulesFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RulesFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
