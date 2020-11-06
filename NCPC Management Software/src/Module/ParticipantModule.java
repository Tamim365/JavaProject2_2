/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import Object.Coach;
import Object.CoachInfo;
import Object.Participant;
import Object.ParticipantInfo;
import Object.Team;
import java.awt.event.KeyEvent;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.awt.List;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class ParticipantModule extends javax.swing.JFrame {

    HashMap<String, Participant> allParticipantInfo;
    HashMap<String, Coach> allCoachInfo;
    HashMap<String, Team> allTeamInfo;
    
    public ParticipantModule() {
        setupFrame();
    }
    
    public ParticipantModule(HashMap<String, Participant> PartInfo, Participant participant , HashMap<String, Coach> CoachInfo, HashMap<String, Team> teamInfo) {
        allParticipantInfo = new HashMap<String, Participant>();
        allParticipantInfo.putAll(PartInfo);
        
        allCoachInfo= new HashMap<String, Coach> ();
        allCoachInfo.putAll(CoachInfo);
        
        allTeamInfo = new HashMap<String, Team> ();
        allTeamInfo.putAll(teamInfo);
        
        setupFrame();
        String title = participant.getName();
        this.setTitle(title); 
        setValues(participant);
    }
    public void setupFrame(){
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
    public void setValues(Participant pt){
        // In Profile
        handleLabel.setText(pt.handleId);
        nameLabel.setText(pt.name);
        emailLabel.setText(pt.email);
        contactLabel.setText(pt.mobile);
        dobLabel.setText(pt.dateOfBirth);
        unilabel.setText(pt.university);
        genderLabel.setText(pt.gender);
        tshirtLabel.setText(pt.tShirt);
        addressLabel.setText(pt.presentAddress);
        //In Search
        jScrollPane2.setVisible(false);
        searchList.removeAll();
        // In Edit Profile
        mobileCheckLabel.setText("");
        emailCheckLabel.setText("");
        //In general
        participantNameTextField.setText(pt.name);
        participantUniversityTextField.setText(pt.university);
        participantDOBTextField.setText(pt.dateOfBirth);
        participantGenderComboBox.setSelectedItem(pt.gender);
        participantTshirtComboBox.setSelectedItem(pt.tShirt);
        participantPresentAddressTextArea.setText(pt.presentAddress);
        // In Account
        participantHandleIdTextField.setText(pt.handleId);
        participantEmailTextField.setText(pt.email);
        participantMobileTextField.setText(pt.mobile);
    }
    public static boolean isValid(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    
    public static boolean isValidMobile(String mobile) 
    { 
        String mobileRegex = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pat = Pattern.compile(mobileRegex); 
        if (mobile == null) 
            return false; 
        return pat.matcher(mobile).matches(); 
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTextField = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        handleLabel = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        unilabel = new javax.swing.JLabel();
        tshirtLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        teamPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        instructionPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        editProfilePanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        participantNameTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        participantEmailTextField = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        participantHandleIdTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        participantMobileTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        participantDOBTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        participantGenderComboBox = new javax.swing.JComboBox<>();
        participantTshirtComboBox = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        participantPresentAddressTextArea = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        participantPasswordField = new javax.swing.JPasswordField();
        participantUniversityTextField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        participantPasswordField1 = new javax.swing.JPasswordField();
        jLabel31 = new javax.swing.JLabel();
        participantPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        emailCheckLabel = new javax.swing.JLabel();
        mobileCheckLabel = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        viewProfileBtn = new javax.swing.JLabel();
        viewTeamBtn = new javax.swing.JLabel();
        viewInstructionBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        editProfileBtn = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchTextField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusLost(evt);
            }
        });
        searchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseExited(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyTyped(evt);
            }
        });
        getContentPane().add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 83, 240, 40));

        homePanel.setOpaque(false);
        homePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Home");
        homePanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 160, 40));

        jTabbedPane1.addTab("tab3", homePanel);

        profilePanel.setOpaque(false);
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Profile");
        profilePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 160, 40));

        emailLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Set Text");
        profilePanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 440, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setText("Handle ID        :");
        profilePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, 30));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("Full Name        :");
        profilePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 255));
        jLabel8.setText("Date of Birth   :");
        profilePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 140, 30));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 255));
        jLabel9.setText("Contact            :");
        profilePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 170, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 255));
        jLabel10.setText("University        :");
        profilePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 255, 255));
        jLabel11.setText("Address            :");
        profilePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 140, 30));

        handleLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        handleLabel.setForeground(new java.awt.Color(255, 255, 255));
        handleLabel.setText("Set Text");
        profilePanel.add(handleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 440, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 255, 255));
        jLabel13.setText("Email                :");
        profilePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, 30));

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        jLabel14.setText("Gender             :");
        profilePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 140, 30));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 255));
        jLabel15.setText("T-Shirt              :");
        profilePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, 30));

        dobLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(255, 255, 255));
        dobLabel.setText("Set Text");
        profilePanel.add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 440, 30));

        contactLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        contactLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactLabel.setText("Set Text");
        profilePanel.add(contactLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 440, 30));

        genderLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Set Text");
        profilePanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 440, 30));

        unilabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        unilabel.setForeground(new java.awt.Color(255, 255, 255));
        unilabel.setText("Set Text");
        profilePanel.add(unilabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 440, 30));

        tshirtLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        tshirtLabel.setForeground(new java.awt.Color(255, 255, 255));
        tshirtLabel.setText("Set Text");
        profilePanel.add(tshirtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 440, 30));

        addressLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Set Text");
        profilePanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 440, 30));

        nameLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Set Text");
        profilePanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 440, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/profile.png"))); // NOI18N
        profilePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jTabbedPane1.addTab("tab2", profilePanel);

        teamPanel.setOpaque(false);
        teamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("My Team");
        teamPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 230, 60));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Currently, you are not assigned to any team!");
        teamPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        jTabbedPane1.addTab("tab1", teamPanel);

        instructionPanel.setOpaque(false);
        instructionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Instructions");
        instructionPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 290, 40));

        jTabbedPane1.addTab("tab3", instructionPanel);

        editProfilePanel.setOpaque(false);
        editProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Account");
        editProfilePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 200, 40));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Full Name     :");
        editProfilePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 130, 30));

        participantNameTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        participantNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        participantNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantNameTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 290, 30));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Email         :");
        editProfilePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 110, 30));

        participantEmailTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        participantEmailTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        participantEmailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                participantEmailTextFieldFocusLost(evt);
            }
        });
        participantEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantEmailTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 260, 30));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Handle Id  :");
        editProfilePanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 100, 30));

        participantHandleIdTextField.setEditable(false);
        participantHandleIdTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        participantHandleIdTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        participantHandleIdTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                participantHandleIdTextFieldFocusLost(evt);
            }
        });
        participantHandleIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantHandleIdTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantHandleIdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 260, 30));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Mobile      :");
        editProfilePanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 100, 30));

        participantMobileTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        participantMobileTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        participantMobileTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                participantMobileTextFieldFocusLost(evt);
            }
        });
        participantMobileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantMobileTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 260, 30));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("University      :");
        editProfilePanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, 30));

        participantDOBTextField.setEditable(false);
        participantDOBTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        participantDOBTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        participantDOBTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantDOBTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantDOBTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 290, 30));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Date of Birth :");
        editProfilePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Gender          :");
        editProfilePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 120, 30));

        participantGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female", "Other" }));
        participantGenderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantGenderComboBoxActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantGenderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 100, 30));

        participantTshirtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "S", "M", "L", "XL", "XXL" }));
        participantTshirtComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantTshirtComboBoxActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantTshirtComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 100, 30));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Address         :");
        editProfilePanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 130, 30));

        participantPresentAddressTextArea.setColumns(20);
        participantPresentAddressTextArea.setRows(3);
        participantPresentAddressTextArea.setTabSize(4);
        participantPresentAddressTextArea.setToolTipText("");
        participantPresentAddressTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(participantPresentAddressTextArea);

        editProfilePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 290, 90));

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Old Password        :");
        editProfilePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 180, 30));
        editProfilePanel.add(participantPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 260, 30));

        participantUniversityTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        participantUniversityTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        participantUniversityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                participantUniversityTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(participantUniversityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 290, 30));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("T-shirt  :");
        editProfilePanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 80, 30));

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("New Password       :");
        editProfilePanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 180, 30));
        editProfilePanel.add(participantPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 260, 30));

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Confirm Password :");
        editProfilePanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 170, 30));
        editProfilePanel.add(participantPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 260, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Save");
        editProfilePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 560, 150, 50));

        emailCheckLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        emailCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        emailCheckLabel.setText("Invalid");
        editProfilePanel.add(emailCheckLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 80, 30));

        mobileCheckLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mobileCheckLabel.setForeground(new java.awt.Color(255, 51, 51));
        mobileCheckLabel.setText("Invalid");
        editProfilePanel.add(mobileCheckLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 80, 30));

        jLabel32.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 51, 51));
        jLabel32.setText("Edit Profile");
        editProfilePanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 280, 40));

        jLabel33.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 51, 51));
        jLabel33.setText("General");
        editProfilePanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 200, 40));

        jTabbedPane1.addTab("tab3", editProfilePanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, -30, 940, 820));

        jScrollPane2.setAutoscrolls(true);

        searchList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        searchList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        searchList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchList.setOpaque(false);
        searchList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchListKeyPressed(evt);
            }
        });
        searchList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                searchListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(searchList);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 240, 60));

        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 110, -1));

        viewProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/participant/viewProfileButton_1.png"))); // NOI18N
        viewProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProfileBtnMouseClicked(evt);
            }
        });
        getContentPane().add(viewProfileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, -1));

        viewTeamBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/participant/viewTeamButton_1.png"))); // NOI18N
        viewTeamBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTeamBtnMouseClicked(evt);
            }
        });
        getContentPane().add(viewTeamBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, -1));

        viewInstructionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/participant/viewInstructionButton_1.png"))); // NOI18N
        viewInstructionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewInstructionBtnMouseClicked(evt);
            }
        });
        getContentPane().add(viewInstructionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, -1, -1));

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/participant/logOutButton_1.png"))); // NOI18N
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        getContentPane().add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, -1, -1));

        editProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/participant/editProfileButton_1.png"))); // NOI18N
        editProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProfileBtnMouseClicked(evt);
            }
        });
        getContentPane().add(editProfileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/participantModuleBG.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Do you want to Log out?","Close",JOptionPane.YES_NO_OPTION);
        if(opt == 0) {
            this.setVisible(false);
            HomeFrame home = new HomeFrame(allParticipantInfo , allCoachInfo, allTeamInfo);
            home.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void viewTeamBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTeamBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_viewTeamBtnMouseClicked

    private void viewProfileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_viewProfileBtnMouseClicked

    private void editProfileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_editProfileBtnMouseClicked

    private void viewInstructionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInstructionBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_viewInstructionBtnMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void participantNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantNameTextFieldActionPerformed

    private void participantEmailTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_participantEmailTextFieldFocusLost
        // TODO add your handling code here:
        String email = participantEmailTextField.getText().toString();
        if(!isValid(email)){
            emailCheckLabel.setText("Invalid Email Address!");
        }
        else
        emailCheckLabel.setText("");
    }//GEN-LAST:event_participantEmailTextFieldFocusLost

    private void participantEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantEmailTextFieldActionPerformed

    private void participantHandleIdTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_participantHandleIdTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_participantHandleIdTextFieldFocusLost

    private void participantHandleIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantHandleIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantHandleIdTextFieldActionPerformed

    private void participantMobileTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_participantMobileTextFieldFocusLost
        // TODO add your handling code here:
        String mobile = participantMobileTextField.getText().toString();
        if(!isValidMobile(mobile)) mobileCheckLabel.setText("Invalid Mobile No!");
        else mobileCheckLabel.setText("");
    }//GEN-LAST:event_participantMobileTextFieldFocusLost

    private void participantMobileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantMobileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantMobileTextFieldActionPerformed

    private void participantDOBTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantDOBTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantDOBTextFieldActionPerformed

    private void participantGenderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantGenderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantGenderComboBoxActionPerformed

    private void participantTshirtComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantTshirtComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantTshirtComboBoxActionPerformed

    private void participantUniversityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_participantUniversityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_participantUniversityTextFieldActionPerformed

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        // TODO add your handling code here:
        jScrollPane2.setVisible(false);
        searchList.removeAll();
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchTextFieldKeyTyped

    private void searchTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyReleased
        // TODO add your handling code here:
        CharSequence s = searchTextField.getText().toString().trim();
        if(s.length()<1) 
        {
            jScrollPane2.setVisible(false);
            searchList.removeAll();
            return;
        }
        Vector<String> list = new Vector<String>();
        for(String str : allParticipantInfo.keySet()) {
            if(str.contains(s)){
                list.add(str);
            }
        }
        searchList.setListData(list);
        if(list.size()>=1){
            searchList.setSelectedIndex(0);
            jScrollPane2.setVisible(true);
        }
        else{
            jScrollPane2.setVisible(false);
            searchList.removeAll();
        }
    }//GEN-LAST:event_searchTextFieldKeyReleased

    private void searchListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListKeyPressed

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if(searchList.getSelectedIndex() >= 0){
                searchTextField.setText(searchList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void searchListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListValueChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchListValueChanged

    private void searchTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseEntered
        // TODO add your handling code here
    }//GEN-LAST:event_searchTextFieldMouseEntered

    private void searchTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldMouseExited

    private void searchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldMouseClicked

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
            java.util.logging.Logger.getLogger(ParticipantModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ParticipantModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ParticipantModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ParticipantModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ParticipantModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel editProfileBtn;
    private javax.swing.JPanel editProfilePanel;
    private javax.swing.JLabel emailCheckLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel handleLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel instructionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel mobileCheckLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField participantDOBTextField;
    private javax.swing.JTextField participantEmailTextField;
    private javax.swing.JComboBox<String> participantGenderComboBox;
    private javax.swing.JTextField participantHandleIdTextField;
    private javax.swing.JTextField participantMobileTextField;
    private javax.swing.JTextField participantNameTextField;
    private javax.swing.JPasswordField participantPasswordField;
    private javax.swing.JPasswordField participantPasswordField1;
    private javax.swing.JPasswordField participantPasswordField2;
    private javax.swing.JTextArea participantPresentAddressTextArea;
    private javax.swing.JComboBox<String> participantTshirtComboBox;
    private javax.swing.JTextField participantUniversityTextField;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JList<String> searchList;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel teamPanel;
    private javax.swing.JLabel tshirtLabel;
    private javax.swing.JLabel unilabel;
    private javax.swing.JLabel viewInstructionBtn;
    private javax.swing.JLabel viewProfileBtn;
    private javax.swing.JLabel viewTeamBtn;
    // End of variables declaration//GEN-END:variables
}
