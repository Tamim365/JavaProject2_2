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
import Object.TeamInfo;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author splash365 <tamim.365.ti at gmail.com>
 */
public class CoachModule extends javax.swing.JFrame {

    HashMap<String, Participant> allParticipantInfo;
    HashMap<String, Coach> allCoachInfo;
    HashMap<String, Team> allTeamInfo;
    
    public CoachModule() {
        setupFrame();
    }
    
    public CoachModule(HashMap<String, Participant> PartInfo, Coach coach, HashMap<String, Coach> CoachInfo ) {
        allParticipantInfo = new HashMap<String, Participant>();
        allParticipantInfo.putAll(PartInfo);
        
        allCoachInfo= new HashMap<String, Coach> ();
        allCoachInfo.putAll(CoachInfo);
        
        allTeamInfo = new HashMap<String, Team>();
        
        setupFrame();
        String title = coach.name;
        this.setTitle(title); 
        setValues(coach);
    }
    public void setupFrame(){
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //In Search
        jScrollPane2.setVisible(false);
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
    public void setValues(Coach ch){
        // In Profile
        nameLabel.setText(ch.name);
        emailLabel.setText(ch.email);
        contactLabel.setText(ch.mobile);
        dobLabel.setText(ch.dateOfBirth);
        unilabel.setText(ch.university);
        positionLabel.setText(ch.position);
        tshirtLabel.setText(ch.tShirt);
        addressLabel.setText(ch.presentAddress);
        genderLabel.setText(ch.gender);
        //In Search
        jScrollPane2.setVisible(false);
        searchList.removeAll();
        // In Edit Profile
        mobileCheckLabel.setText("");
        emailCheckLabel.setText("");
        //In general
        coachNameTextField.setText(ch.name);
        coachUniversityTextField.setText(ch.university);
        coachDOBTextField.setText(ch.dateOfBirth);
        coachGenderComboBox.setSelectedItem(ch.gender);
        coachTshirtComboBox.setSelectedItem(ch.tShirt);
        coachPresentAddressTextArea.setText(ch.presentAddress);
        // In Account
        coachEmailTextField.setText(ch.email);
        coachMobileTextField.setText(ch.mobile);
        //Team Registration
        jScrollPaneM1.setVisible(false);
        searchListM1.removeAll();
        jScrollPaneM2.setVisible(false);
        searchListM2.removeAll();
        jScrollPaneM3.setVisible(false);
        searchListM3.removeAll();
        handleNotFoundM1.setText("");
        handleNotFoundM2.setText("");
        handleNotFoundM3.setText("");
        coachRegNameTextField.setText(ch.name);
        coachRegEmailTextField.setText(ch.email);
        universityRegNameTextField.setText(ch.university);
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        homePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dobLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        unilabel = new javax.swing.JLabel();
        tshirtLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        teamPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        instructionPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        editProfilePanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        coachNameTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        coachEmailTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        coachMobileTextField = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        coachDOBTextField = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        coachGenderComboBox = new javax.swing.JComboBox<>();
        coachTshirtComboBox = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coachPresentAddressTextArea = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        coachPasswordField = new javax.swing.JPasswordField();
        coachUniversityTextField = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        coachNewPasswordField = new javax.swing.JPasswordField();
        jLabel31 = new javax.swing.JLabel();
        participantPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        emailCheckLabel = new javax.swing.JLabel();
        mobileCheckLabel = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        coachPositionTextField = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        editTeamPanel = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();
        jLabel36 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        TeamRegistrationPanel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        universityRegNameTextField = new javax.swing.JTextField();
        teamRegNameTextField = new javax.swing.JTextField();
        searchTextFieldM1 = new javax.swing.JTextField();
        jScrollPaneM1 = new javax.swing.JScrollPane();
        searchListM1 = new javax.swing.JList<>();
        searchTextFieldM2 = new javax.swing.JTextField();
        jScrollPaneM2 = new javax.swing.JScrollPane();
        searchListM2 = new javax.swing.JList<>();
        searchTextFieldM3 = new javax.swing.JTextField();
        jScrollPaneM3 = new javax.swing.JScrollPane();
        searchListM3 = new javax.swing.JList<>();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        coachRegEmailTextField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        coachRegNameTextField = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        registerBtn = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        handleNotFoundM3 = new javax.swing.JLabel();
        handleNotFoundM1 = new javax.swing.JLabel();
        handleNotFoundM2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        viewProfileBtn = new javax.swing.JLabel();
        viewTeamBtn = new javax.swing.JLabel();
        viewInstructionBtn = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        editProfileBtn = new javax.swing.JLabel();
        editProfileBtn1 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        profilePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 140, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 255, 255));
        jLabel13.setText("Email                :");
        profilePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, 30));

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        jLabel14.setText("Position           :");
        profilePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 140, 30));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 255));
        jLabel15.setText("T-Shirt              :");
        profilePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 140, 30));

        dobLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(255, 255, 255));
        dobLabel.setText("Set Text");
        profilePanel.add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 440, 30));

        contactLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        contactLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactLabel.setText("Set Text");
        profilePanel.add(contactLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 440, 30));

        positionLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        positionLabel.setForeground(new java.awt.Color(255, 255, 255));
        positionLabel.setText("Set Text");
        profilePanel.add(positionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 440, 30));

        unilabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        unilabel.setForeground(new java.awt.Color(255, 255, 255));
        unilabel.setText("Set Text");
        profilePanel.add(unilabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 440, 30));

        tshirtLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        tshirtLabel.setForeground(new java.awt.Color(255, 255, 255));
        tshirtLabel.setText("Set Text");
        profilePanel.add(tshirtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 440, 30));

        addressLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Set Text");
        profilePanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 440, 30));

        nameLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Set Text");
        profilePanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 440, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/profile.png"))); // NOI18N
        profilePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 255));
        jLabel22.setText("Gender             :");
        profilePanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, 30));

        genderLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Set Text");
        profilePanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 440, 30));

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
        editProfilePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 170, 200, 40));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Full Name     :");
        editProfilePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 130, 30));

        coachNameTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachNameTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 290, 30));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Email         :");
        editProfilePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 110, 30));

        coachEmailTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachEmailTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachEmailTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                coachEmailTextFieldFocusLost(evt);
            }
        });
        coachEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachEmailTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 260, 30));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Mobile      :");
        editProfilePanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 100, 30));

        coachMobileTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachMobileTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachMobileTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                coachMobileTextFieldFocusLost(evt);
            }
        });
        coachMobileTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachMobileTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachMobileTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 260, 30));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("University      :");
        editProfilePanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 120, 30));

        coachDOBTextField.setEditable(false);
        coachDOBTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachDOBTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachDOBTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachDOBTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachDOBTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 290, 30));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Date of Birth :");
        editProfilePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 120, 30));

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Gender          :");
        editProfilePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 120, 30));

        coachGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Male", "Female", "Other" }));
        coachGenderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachGenderComboBoxActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachGenderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, 100, 30));

        coachTshirtComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "S", "M", "L", "XL", "XXL" }));
        coachTshirtComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachTshirtComboBoxActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachTshirtComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 100, 30));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Address         :");
        editProfilePanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 130, 30));

        coachPresentAddressTextArea.setColumns(20);
        coachPresentAddressTextArea.setRows(3);
        coachPresentAddressTextArea.setTabSize(4);
        coachPresentAddressTextArea.setToolTipText("");
        coachPresentAddressTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(coachPresentAddressTextArea);

        editProfilePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 290, 90));

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Old Password        :");
        editProfilePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 180, 30));
        editProfilePanel.add(coachPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 350, 260, 30));

        coachUniversityTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachUniversityTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachUniversityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachUniversityTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachUniversityTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 290, 30));

        jLabel29.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("T-shirt  :");
        editProfilePanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 80, 30));

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("New Password       :");
        editProfilePanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 180, 30));
        editProfilePanel.add(coachNewPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 390, 260, 30));

        jLabel31.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Confirm Password :");
        editProfilePanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 170, 30));
        editProfilePanel.add(participantPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 430, 260, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Save");
        editProfilePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 150, 50));

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
        editProfilePanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 200, 40));

        coachPositionTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachPositionTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachPositionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachPositionTextFieldActionPerformed(evt);
            }
        });
        editProfilePanel.add(coachPositionTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 290, 30));

        jLabel34.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Position         :");
        editProfilePanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, 30));

        jTabbedPane1.addTab("tab3", editProfilePanel);

        editTeamPanel.setOpaque(false);
        editTeamPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 51, 51));
        jLabel35.setText("Edit Team");
        editTeamPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 290, 40));

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
        editTeamPanel.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 240, 40));

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

        editTeamPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 240, 60));

        jLabel36.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Currently, you have no team!");
        editTeamPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, -1));

        jButton2.setText("Register a New Team");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        editTeamPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 190, 50));

        jTabbedPane1.addTab("tab3", editTeamPanel);

        TeamRegistrationPanel.setOpaque(false);
        TeamRegistrationPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 51, 51));
        jLabel37.setText("Register New Team");
        TeamRegistrationPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 500, 90));

        universityRegNameTextField.setEditable(false);
        universityRegNameTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        universityRegNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        universityRegNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityRegNameTextFieldFocusLost(evt);
            }
        });
        universityRegNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                universityRegNameTextFieldActionPerformed(evt);
            }
        });
        TeamRegistrationPanel.add(universityRegNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 310, 30));

        teamRegNameTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        teamRegNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        teamRegNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                teamRegNameTextFieldFocusLost(evt);
            }
        });
        teamRegNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamRegNameTextFieldActionPerformed(evt);
            }
        });
        TeamRegistrationPanel.add(teamRegNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 310, 30));

        searchTextFieldM1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchTextFieldM1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldM1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldM1FocusLost(evt);
            }
        });
        searchTextFieldM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldM1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchTextFieldM1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchTextFieldM1MouseExited(evt);
            }
        });
        searchTextFieldM1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldM1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldM1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldM1KeyTyped(evt);
            }
        });
        TeamRegistrationPanel.add(searchTextFieldM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 290, 40));

        jScrollPaneM1.setAutoscrolls(true);

        searchListM1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchListM1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        searchListM1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        searchListM1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchListM1.setOpaque(false);
        searchListM1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchListM1KeyPressed(evt);
            }
        });
        searchListM1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                searchListM1ValueChanged(evt);
            }
        });
        jScrollPaneM1.setViewportView(searchListM1);

        TeamRegistrationPanel.add(jScrollPaneM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 290, 50));

        searchTextFieldM2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchTextFieldM2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldM2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldM2FocusLost(evt);
            }
        });
        searchTextFieldM2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldM2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchTextFieldM2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchTextFieldM2MouseExited(evt);
            }
        });
        searchTextFieldM2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldM2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldM2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldM2KeyTyped(evt);
            }
        });
        TeamRegistrationPanel.add(searchTextFieldM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 490, 290, 40));

        jScrollPaneM2.setAutoscrolls(true);

        searchListM2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchListM2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        searchListM2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        searchListM2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchListM2.setOpaque(false);
        searchListM2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchListM2KeyPressed(evt);
            }
        });
        searchListM2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                searchListM2ValueChanged(evt);
            }
        });
        jScrollPaneM2.setViewportView(searchListM2);

        TeamRegistrationPanel.add(jScrollPaneM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 290, 50));

        searchTextFieldM3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchTextFieldM3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldM3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchTextFieldM3FocusLost(evt);
            }
        });
        searchTextFieldM3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldM3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchTextFieldM3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchTextFieldM3MouseExited(evt);
            }
        });
        searchTextFieldM3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldM3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldM3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTextFieldM3KeyTyped(evt);
            }
        });
        TeamRegistrationPanel.add(searchTextFieldM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 290, 40));

        jScrollPaneM3.setAutoscrolls(true);

        searchListM3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchListM3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        searchListM3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        searchListM3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchListM3.setOpaque(false);
        searchListM3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchListM3KeyPressed(evt);
            }
        });
        searchListM3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                searchListM3ValueChanged(evt);
            }
        });
        jScrollPaneM3.setViewportView(searchListM3);

        TeamRegistrationPanel.add(jScrollPaneM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 290, 50));

        jLabel42.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("University :");
        TeamRegistrationPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 110, 30));

        jLabel43.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Team Name :");
        TeamRegistrationPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 120, 30));

        jLabel45.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("TeamID :");
        TeamRegistrationPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 80, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ncpc_team_");
        TeamRegistrationPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 200, 240, -1));

        jLabel46.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 51, 51));
        jLabel46.setText("Members Information");
        TeamRegistrationPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 380, 40));

        coachRegEmailTextField.setEditable(false);
        coachRegEmailTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachRegEmailTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachRegEmailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachRegEmailTextFieldActionPerformed(evt);
            }
        });
        TeamRegistrationPanel.add(coachRegEmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 290, 30));

        jLabel47.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Email             :");
        TeamRegistrationPanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        jLabel48.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Full Name     :");
        TeamRegistrationPanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, 30));

        coachRegNameTextField.setEditable(false);
        coachRegNameTextField.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        coachRegNameTextField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true));
        coachRegNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachRegNameTextFieldActionPerformed(evt);
            }
        });
        TeamRegistrationPanel.add(coachRegNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 290, 30));

        jLabel49.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Handle ID  :");
        TeamRegistrationPanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 110, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("Member - 1");
        TeamRegistrationPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 170, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("Member - 2");
        TeamRegistrationPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 440, 170, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 51));
        jLabel6.setText("Member - 3");
        TeamRegistrationPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 540, 170, -1));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 51));
        jLabel52.setText("Coach");
        TeamRegistrationPanel.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 100, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        TeamRegistrationPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, 110, 40));

        registerBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerBtn.setText("Register");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        TeamRegistrationPanel.add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 470, 110, 40));

        jLabel53.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Handle ID  :");
        TeamRegistrationPanel.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 110, 30));

        jLabel54.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Handle ID  :");
        TeamRegistrationPanel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 110, 30));

        handleNotFoundM3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        handleNotFoundM3.setForeground(new java.awt.Color(255, 0, 0));
        handleNotFoundM3.setText("Handle Id Not Found!");
        TeamRegistrationPanel.add(handleNotFoundM3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 160, 30));

        handleNotFoundM1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        handleNotFoundM1.setForeground(new java.awt.Color(255, 0, 0));
        handleNotFoundM1.setText("Handle Id Not Found!");
        TeamRegistrationPanel.add(handleNotFoundM1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 160, 30));

        handleNotFoundM2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        handleNotFoundM2.setForeground(new java.awt.Color(255, 0, 0));
        handleNotFoundM2.setText("Handle Id Not Found!");
        TeamRegistrationPanel.add(handleNotFoundM2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 490, 160, 30));

        jTabbedPane1.addTab("tab3", TeamRegistrationPanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, -30, 940, 820));

        jButton4.setText("Home");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 110, -1));

        viewProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/instructor/viewProfileButton_1.png"))); // NOI18N
        viewProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProfileBtnMouseClicked(evt);
            }
        });
        getContentPane().add(viewProfileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, -1, -1));

        viewTeamBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/instructor/viewTeamButton_1.png"))); // NOI18N
        viewTeamBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTeamBtnMouseClicked(evt);
            }
        });
        getContentPane().add(viewTeamBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, -1, -1));

        viewInstructionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/instructor/sendInstructionButton_1.png"))); // NOI18N
        viewInstructionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewInstructionBtnMouseClicked(evt);
            }
        });
        getContentPane().add(viewInstructionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, -1));

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/instructor/logOutButton_1.png"))); // NOI18N
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        getContentPane().add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 610, -1, -1));

        editProfileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/participant/editProfileButton_1.png"))); // NOI18N
        editProfileBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProfileBtnMouseClicked(evt);
            }
        });
        getContentPane().add(editProfileBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, -1, -1));

        editProfileBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/instructor/editTeamButton_1.png"))); // NOI18N
        editProfileBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProfileBtn1MouseClicked(evt);
            }
        });
        getContentPane().add(editProfileBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/participantModuleBG.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldFocusGained

    private void searchTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusLost
        // TODO add your handling code here:
        jScrollPane2.setVisible(false);
        searchList.removeAll();
    }//GEN-LAST:event_searchTextFieldFocusLost

    private void searchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldMouseClicked

    private void searchTextFieldMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseEntered
        // TODO add your handling code here
    }//GEN-LAST:event_searchTextFieldMouseEntered

    private void searchTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldMouseExited

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if(searchList.getSelectedIndex() >= 0){
                searchTextField.setText(searchList.getSelectedValue());
            }
        }
    }//GEN-LAST:event_searchTextFieldKeyPressed

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

    private void searchTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldKeyTyped

    private void coachNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachNameTextFieldActionPerformed

    private void coachEmailTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coachEmailTextFieldFocusLost
        // TODO add your handling code here:
        String email = coachEmailTextField.getText().toString();
        if(!isValid(email)){
            emailCheckLabel.setText("Invalid Email Address!");
        }
        else
        emailCheckLabel.setText("");
    }//GEN-LAST:event_coachEmailTextFieldFocusLost

    private void coachEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachEmailTextFieldActionPerformed

    private void coachMobileTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coachMobileTextFieldFocusLost
        // TODO add your handling code here:
        String mobile = coachMobileTextField.getText().toString();
        if(!isValidMobile(mobile)) mobileCheckLabel.setText("Invalid Mobile No!");
        else mobileCheckLabel.setText("");
    }//GEN-LAST:event_coachMobileTextFieldFocusLost

    private void coachMobileTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachMobileTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachMobileTextFieldActionPerformed

    private void coachDOBTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachDOBTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachDOBTextFieldActionPerformed

    private void coachGenderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachGenderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachGenderComboBoxActionPerformed

    private void coachTshirtComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachTshirtComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachTshirtComboBoxActionPerformed

    private void coachUniversityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachUniversityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachUniversityTextFieldActionPerformed

    private void searchListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListKeyPressed

    private void searchListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_searchListValueChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void viewProfileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProfileBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_viewProfileBtnMouseClicked

    private void viewTeamBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTeamBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_viewTeamBtnMouseClicked

    private void viewInstructionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewInstructionBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_viewInstructionBtnMouseClicked

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Do you want to Log out?","Close",JOptionPane.YES_NO_OPTION);
        if(opt == 0) {
            this.setVisible(false);
            HomeFrame home = new HomeFrame(allParticipantInfo , allCoachInfo);
            home.setVisible(true);
        }
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void editProfileBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
    }//GEN-LAST:event_editProfileBtnMouseClicked

    private void coachPositionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachPositionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachPositionTextFieldActionPerformed

    private void editProfileBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProfileBtn1MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_editProfileBtn1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void universityRegNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityRegNameTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityRegNameTextFieldFocusLost

    private void universityRegNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_universityRegNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_universityRegNameTextFieldActionPerformed

    private void teamRegNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_teamRegNameTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_teamRegNameTextFieldFocusLost

    private void teamRegNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamRegNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teamRegNameTextFieldActionPerformed

    private void coachRegEmailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRegEmailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachRegEmailTextFieldActionPerformed

    private void coachRegNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachRegNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coachRegNameTextFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchTextFieldM1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldM1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM1FocusGained

    private void searchTextFieldM1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldM1FocusLost
        // TODO add your handling code here:
        String handle = searchTextFieldM1.getText().toString();
        ParticipantInfo PI = new ParticipantInfo(allParticipantInfo);
        if(!PI.isValid(handle)) handleNotFoundM1.setText("Handle Id Not Found!");
        else handleNotFoundM1.setText("");
        jScrollPaneM1.setVisible(false);
        searchListM1.removeAll();
    }//GEN-LAST:event_searchTextFieldM1FocusLost

    private void searchTextFieldM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM1MouseClicked

    private void searchTextFieldM1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM1MouseEntered

    private void searchTextFieldM1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM1MouseExited

    private void searchTextFieldM1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if(searchListM1.getSelectedIndex() >= 0){
                searchTextFieldM1.setText(searchListM1.getSelectedValue());
            }
        }
    }//GEN-LAST:event_searchTextFieldM1KeyPressed

    private void searchTextFieldM1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM1KeyReleased
        // TODO add your handling code here:
        CharSequence s = searchTextFieldM1.getText().toString().trim();
        if(s.length()<1)
        {
            jScrollPaneM1.setVisible(false);
            searchListM1.removeAll();
            return;
        }
        Vector<String> list = new Vector<String>();
        for(String str : allParticipantInfo.keySet()) {
            if(str.contains(s)){
                list.add(str);
            }
        }
        searchListM1.setListData(list);
        if(list.size()>=1){
            searchListM1.setSelectedIndex(0);
            jScrollPaneM1.setVisible(true);
        }
        else{
            jScrollPaneM1.setVisible(false);
            searchListM1.removeAll();
        }
    }//GEN-LAST:event_searchTextFieldM1KeyReleased

    private void searchTextFieldM1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM1KeyTyped

    private void searchListM1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchListM1KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchListM1KeyPressed

    private void searchListM1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListM1ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListM1ValueChanged

    private void searchTextFieldM2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldM2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM2FocusGained

    private void searchTextFieldM2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldM2FocusLost
        // TODO add your handling code here:
        String handle = searchTextFieldM2.getText().toString();
        ParticipantInfo PI = new ParticipantInfo(allParticipantInfo);
        if(!PI.isValid(handle)) handleNotFoundM2.setText("Handle Id Not Found!");
        else handleNotFoundM2.setText("");
        jScrollPaneM2.setVisible(false);
        searchListM2.removeAll();
    }//GEN-LAST:event_searchTextFieldM2FocusLost

    private void searchTextFieldM2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM2MouseClicked

    private void searchTextFieldM2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM2MouseEntered

    private void searchTextFieldM2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM2MouseExited

    private void searchTextFieldM2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if(searchListM2.getSelectedIndex() >= 0){
                searchTextFieldM2.setText(searchListM2.getSelectedValue());
            }
        }
    }//GEN-LAST:event_searchTextFieldM2KeyPressed

    private void searchTextFieldM2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM2KeyReleased
        // TODO add your handling code here:
        CharSequence s = searchTextFieldM2.getText().toString().trim();
        if(s.length()<1)
        {
            jScrollPaneM2.setVisible(false);
            searchListM2.removeAll();
            return;
        }
        Vector<String> list = new Vector<String>();
        for(String str : allParticipantInfo.keySet()) {
            if(str.contains(s)){
                list.add(str);
            }
        }
        searchListM2.setListData(list);
        if(list.size()>=1){
            searchListM2.setSelectedIndex(0);
            jScrollPaneM2.setVisible(true);
        }
        else{
            jScrollPaneM2.setVisible(false);
            searchListM2.removeAll();
        }
    }//GEN-LAST:event_searchTextFieldM2KeyReleased

    private void searchTextFieldM2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM2KeyTyped

    private void searchListM2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchListM2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListM2KeyPressed

    private void searchListM2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListM2ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListM2ValueChanged

    private void searchTextFieldM3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldM3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM3FocusGained

    private void searchTextFieldM3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldM3FocusLost
        // TODO add your handling code here:
        String handle = searchTextFieldM3.getText().toString();
        ParticipantInfo PI = new ParticipantInfo(allParticipantInfo);
        if(!PI.isValid(handle)) handleNotFoundM3.setText("Handle Id Not Found!");
        else handleNotFoundM3.setText("");
        jScrollPaneM3.setVisible(false);
        searchListM3.removeAll();
    }//GEN-LAST:event_searchTextFieldM3FocusLost

    private void searchTextFieldM3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM3MouseClicked

    private void searchTextFieldM3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM3MouseEntered

    private void searchTextFieldM3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldM3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM3MouseExited

    private void searchTextFieldM3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM3KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if(searchListM3.getSelectedIndex() >= 0){
                searchTextFieldM3.setText(searchListM3.getSelectedValue());
            }
        }
    }//GEN-LAST:event_searchTextFieldM3KeyPressed

    private void searchTextFieldM3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM3KeyReleased
        // TODO add your handling code here:
        CharSequence s = searchTextFieldM3.getText().toString().trim();
        if(s.length()<1)
        {
            jScrollPaneM3.setVisible(false);
            searchListM3.removeAll();
            return;
        }
        Vector<String> list = new Vector<String>();
        for(String str : allParticipantInfo.keySet()) {
            if(str.contains(s)){
                list.add(str);
            }
        }
        searchListM3.setListData(list);
        if(list.size()>=1){
            searchListM3.setSelectedIndex(0);
            jScrollPaneM3.setVisible(true);
        }
        else{
            jScrollPaneM3.setVisible(false);
            searchListM3.removeAll();
        }
    }//GEN-LAST:event_searchTextFieldM3KeyReleased

    private void searchTextFieldM3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldM3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldM3KeyTyped

    private void searchListM3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchListM3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListM3KeyPressed

    private void searchListM3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListM3ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListM3ValueChanged

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String teamName = teamRegNameTextField.getText().toString(); 
            String teamUniversity = universityRegNameTextField.getText().toString();
            String coachName = coachRegNameTextField.getText().toString();
            String coachEmail = coachRegEmailTextField.getText().toString();
            
            String member1 = searchTextFieldM1.getText().toString();
            String member2 = searchTextFieldM2.getText().toString();
            String member3 = searchTextFieldM3.getText().toString();
            
            ArrayList<String> members = new ArrayList<String>();
            members.add(member1);
            members.add(member2);
            members.add(member3);
            
            TeamInfo TI = new TeamInfo(allTeamInfo);
            Random rand = new Random();
            int Id = (int) rand.nextInt(5000);
            while (TI.isValid("ncpc_team_"+Id)) {  
                Id = (int) rand.nextInt(5000);
            }
            String teamId = "ncpc_team_" + Integer.toString(Id);
            Team team = new Team(members, teamName, teamUniversity, coachName, coachEmail, teamId);
            
            int opt = JOptionPane.showConfirmDialog(null, "Do you want to Submit?","Confirmation",JOptionPane.YES_NO_OPTION);
            if(opt == 0) 
            {

                allTeamInfo.put(teamId, team);
                TI = new TeamInfo(allTeamInfo);
                TI.writeData();
                
                teamRegNameTextField.setText("");
                searchTextFieldM1.setText("");
                searchTextFieldM2.setText("");
                searchTextFieldM3.setText("");
                
                JOptionPane.showMessageDialog(null, "Registration Successful");
            }
        }
//        catch (HeadlessException | IOException e){
//            JOptionPane.showMessageDialog(null, "Registration Failed! Try again later..", "DataBase I/O Error", JOptionPane.ERROR_MESSAGE);
//        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Registration Failed! Try again later..", "DataBase Element Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_registerBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CoachModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CoachModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CoachModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CoachModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CoachModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JPanel TeamRegistrationPanel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField coachDOBTextField;
    private javax.swing.JTextField coachEmailTextField;
    private javax.swing.JComboBox<String> coachGenderComboBox;
    private javax.swing.JTextField coachMobileTextField;
    private javax.swing.JTextField coachNameTextField;
    private javax.swing.JPasswordField coachNewPasswordField;
    private javax.swing.JPasswordField coachPasswordField;
    private javax.swing.JTextField coachPositionTextField;
    private javax.swing.JTextArea coachPresentAddressTextArea;
    private javax.swing.JTextField coachRegEmailTextField;
    private javax.swing.JTextField coachRegNameTextField;
    private javax.swing.JComboBox<String> coachTshirtComboBox;
    private javax.swing.JTextField coachUniversityTextField;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel editProfileBtn;
    private javax.swing.JLabel editProfileBtn1;
    private javax.swing.JPanel editProfilePanel;
    private javax.swing.JPanel editTeamPanel;
    private javax.swing.JLabel emailCheckLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel handleNotFoundM1;
    private javax.swing.JLabel handleNotFoundM2;
    private javax.swing.JLabel handleNotFoundM3;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel instructionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneM1;
    private javax.swing.JScrollPane jScrollPaneM2;
    private javax.swing.JScrollPane jScrollPaneM3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JLabel mobileCheckLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField participantPasswordField2;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton registerBtn;
    private javax.swing.JList<String> searchList;
    private javax.swing.JList<String> searchListM1;
    private javax.swing.JList<String> searchListM2;
    private javax.swing.JList<String> searchListM3;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTextField searchTextFieldM1;
    private javax.swing.JTextField searchTextFieldM2;
    private javax.swing.JTextField searchTextFieldM3;
    private javax.swing.JPanel teamPanel;
    private javax.swing.JTextField teamRegNameTextField;
    private javax.swing.JLabel tshirtLabel;
    private javax.swing.JLabel unilabel;
    private javax.swing.JTextField universityRegNameTextField;
    private javax.swing.JLabel viewInstructionBtn;
    private javax.swing.JLabel viewProfileBtn;
    private javax.swing.JLabel viewTeamBtn;
    // End of variables declaration//GEN-END:variables
}
