/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Module;

import ExceptionClasses.HandleIdNotFoundException;
import ExceptionClasses.TeamNotFoundException;
import ExceptionClasses.WrongEmailException;
import Object.Coach;
import Object.CoachInfo;
import Object.Participant;
import Object.ParticipantInfo;
import Object.Team;
import Object.TeamInfo;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tamim-PC
 */
public class AdminModule extends javax.swing.JFrame {

    HashMap<String, Participant> allParticipantInfo;
    HashMap<String, Coach> allCoachInfo;
    HashMap<String, Team> allTeamInfo;
    
    public AdminModule() {
        setupFrame();
    }
    public AdminModule(HashMap<String, Participant> PartInfo , HashMap<String, Coach> CoachInfo, HashMap<String, Team> teamInfo){
        allParticipantInfo = new HashMap<String, Participant>();
        allParticipantInfo.putAll(PartInfo);
        
        ///added
        allCoachInfo= new HashMap<String, Coach> ();
        allCoachInfo.putAll(CoachInfo);
        
        allTeamInfo = new HashMap<String, Team> ();
        allTeamInfo.putAll(teamInfo);
        
        setupFrame();
    }
    public void setupFrame(){
        initComponents();
        this.setSize(1366,768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        renderAllTable();
        
        SetParticipantTable();
        SetCoachTable();
        SetUniversityTable();
        
        jScrollPane2.setVisible(false);
        searchList.removeAll();
        
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
    public void renderAllTable(){
        /// Participant Table Render
        participantTable.getTableHeader().setFont(new Font("Segeo UI",Font.BOLD, 18));
        ((DefaultTableCellRenderer)participantTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        participantTable.setDefaultRenderer(String.class, centerRenderer);
        ///Coach Table Render
        coachTable.getTableHeader().setFont(new Font("Segeo UI",Font.BOLD, 18));
        ((DefaultTableCellRenderer)coachTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        coachTable.setDefaultRenderer(String.class, centerRenderer);
        ///University Table Render
        universityTable.getTableHeader().setFont(new Font("Segeo UI",Font.BOLD, 18));
        ((DefaultTableCellRenderer)universityTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(0);
        universityTable.setDefaultRenderer(String.class, centerRenderer);
    }
    public void SetParticipantTable(){
        DefaultTableModel tblModel = (DefaultTableModel) participantTable.getModel();
        tblModel.setRowCount(0);
        for (String str : allParticipantInfo.keySet()){
            String name = allParticipantInfo.get(str).name;
            String uni = allParticipantInfo.get(str).university;
            String id = allParticipantInfo.get(str).handleId;
            String[] addString = {name, uni, id};
            tblModel.addRow(addString);
        } 
    }
    public void SetCoachTable(){
        DefaultTableModel tblModel = (DefaultTableModel) coachTable.getModel();
        tblModel.setRowCount(0);
        for (String str : allCoachInfo.keySet()){
            String name = allCoachInfo.get(str).name;
            String uni = allCoachInfo.get(str).university;
            String id = allCoachInfo.get(str).email;
            String[] addString = {name, uni, id};
            tblModel.addRow(addString);
        } 
    }
    public void SetUniversityTable(){
        DefaultTableModel tblModel = (DefaultTableModel) universityTable.getModel();
        tblModel.setRowCount(0);
        for (String str : allTeamInfo.keySet()){
            String name = allTeamInfo.get(str).teamName;
            String uni = allTeamInfo.get(str).university;
            String id = allTeamInfo.get(str).teamId;
            String payment = new String();
            if(allTeamInfo.get(str).paymentStatus) payment = "Completed";
            else payment = "Due";
            String[] addString = {uni, name, id, payment};
            tblModel.addRow(addString);
        }
    }
    public void setPartcipantValue(Participant pt)
    {
        handleLabel.setText(pt.handleId);
        nameLabel.setText(pt.name);
        emailLabel.setText(pt.email);
        contactLabel.setText(pt.mobile);
        dobLabel.setText(pt.dateOfBirth);
        unilabel.setText(pt.university);
        genderLabel.setText(pt.gender);
        tshirtLabel.setText(pt.tShirt);
        addressLabel.setText(pt.presentAddress);
    }
    public void setCoachValue(Coach ch){
        // In Profile
        nameLabel1.setText(ch.name);
        emailLabel1.setText(ch.email);
        contactLabel1.setText(ch.mobile);
        dobLabel1.setText(ch.dateOfBirth);
        unilabel1.setText(ch.university);
        positionLabel.setText(ch.position);
        tshirtLabel1.setText(ch.tShirt);
        addressLabel1.setText(ch.presentAddress);
        genderLabel1.setText(ch.gender);
    }
    public void setTeamValue(Team team)
    {
        ParticipantInfo pi = new ParticipantInfo(allParticipantInfo);
        String member1 = pi.find(team.member1).name + " (" + pi.find(team.member1).handleId + ")";
        String member2 = pi.find(team.member2).name + " (" + pi.find(team.member2).handleId + ")";
        String member3 = pi.find(team.member3).name + " (" + pi.find(team.member3).handleId + ")";
        
        viewTeamTeamName.setText(team.teamName);
        viewTeamUniversityName.setText(team.university);
        viewTeamTeamId.setText(team.teamId);
        viewTeamCoachName.setText(team.coachName);
        viewTeamCoachEmail.setText(team.coahEmail);
        viewTeamMember1.setText(member1);
        viewTeamMember2.setText(member2);
        viewTeamMember3.setText(member3);
        
        if(team.paymentStatus) 
        {
            teamCompletePaymentBtn.setVisible(false);
            viewTeamPaymentStatus.setText("Payment Completed!");
        }
        else{
            teamCompletePaymentBtn.setVisible(true);
            viewTeamPaymentStatus.setText("Payment Due");
        }
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
        coachHomePanel = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        participntPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        participantTableScrollPane = new javax.swing.JScrollPane();
        participantTable = new javax.swing.JTable();
        partDelete = new javax.swing.JButton();
        partProfile = new javax.swing.JButton();
        participantProfilePanel = new javax.swing.JPanel();
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
        coachesPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        coachTableScrollPane1 = new javax.swing.JScrollPane();
        coachTable = new javax.swing.JTable();
        coachProfile = new javax.swing.JButton();
        coachDelete = new javax.swing.JButton();
        universityPanel = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        participantTableScrollPane2 = new javax.swing.JScrollPane();
        universityTable = new javax.swing.JTable();
        uniDelete = new javax.swing.JButton();
        teamProfile = new javax.swing.JButton();
        CoachProfilePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        emailLabel1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        dobLabel1 = new javax.swing.JLabel();
        contactLabel1 = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        unilabel1 = new javax.swing.JLabel();
        tshirtLabel1 = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        nameLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        genderLabel1 = new javax.swing.JLabel();
        teamProfilePanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        viewTeamTeamId = new javax.swing.JLabel();
        viewTeamTeamName = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        viewTeamCoachEmail = new javax.swing.JLabel();
        viewTeamCoachName = new javax.swing.JLabel();
        viewTeamMember1 = new javax.swing.JLabel();
        viewTeamPaymentStatus = new javax.swing.JLabel();
        viewTeamMember2 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        viewTeamMember3 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        teamCompletePaymentBtn = new javax.swing.JButton();
        viewTeamUniversityName = new javax.swing.JLabel();
        viewTeamUniversityName2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchList = new javax.swing.JList<>();
        participantsButton = new javax.swing.JLabel();
        coachesButton = new javax.swing.JLabel();
        universityButton = new javax.swing.JLabel();
        logoutButton = new javax.swing.JLabel();
        coachHomeBtn = new javax.swing.JLabel();
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

        coachHomePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("Home");
        coachHomePanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 300, 60));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backgrounds/homeBackground.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        coachHomePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("tab8", coachHomePanel);

        participntPanel.setOpaque(false);
        participntPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("Participants");
        participntPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 310, 70));

        participantTableScrollPane.setOpaque(false);

        participantTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        participantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "University", "Handle Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        participantTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        participantTable.setOpaque(false);
        participantTable.setRowHeight(40);
        participantTable.setRowMargin(1);
        participantTable.getTableHeader().setResizingAllowed(false);
        participantTable.getTableHeader().setReorderingAllowed(false);
        participantTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                participantTableMouseClicked(evt);
            }
        });
        participantTableScrollPane.setViewportView(participantTable);
        participantTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        participntPanel.add(participantTableScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 770, -1));

        partDelete.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        partDelete.setText("Delete");
        partDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partDeleteActionPerformed(evt);
            }
        });
        participntPanel.add(partDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 630, 130, 40));

        partProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        partProfile.setText("Profile");
        partProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partProfileActionPerformed(evt);
            }
        });
        participntPanel.add(partProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 130, 40));

        jTabbedPane1.addTab("tab3", participntPanel);

        participantProfilePanel.setOpaque(false);
        participantProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Profile");
        participantProfilePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 160, 40));

        emailLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("Set Text");
        participantProfilePanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 440, 30));

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 255));
        jLabel6.setText("Handle ID        :");
        participantProfilePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 140, 30));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 255));
        jLabel7.setText("Full Name        :");
        participantProfilePanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 255));
        jLabel8.setText("Date of Birth   :");
        participantProfilePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 140, 30));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 255));
        jLabel9.setText("Contact            :");
        participantProfilePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 170, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 255));
        jLabel10.setText("University        :");
        participantProfilePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, 30));

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 255, 255));
        jLabel11.setText("Address            :");
        participantProfilePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 140, 30));

        handleLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        handleLabel.setForeground(new java.awt.Color(255, 255, 255));
        handleLabel.setText("Set Text");
        participantProfilePanel.add(handleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 440, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 255, 255));
        jLabel13.setText("Email                :");
        participantProfilePanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, 30));

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 255, 255));
        jLabel14.setText("Gender             :");
        participantProfilePanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 140, 30));

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 255, 255));
        jLabel15.setText("T-Shirt              :");
        participantProfilePanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, 30));

        dobLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        dobLabel.setForeground(new java.awt.Color(255, 255, 255));
        dobLabel.setText("Set Text");
        participantProfilePanel.add(dobLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 440, 30));

        contactLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        contactLabel.setForeground(new java.awt.Color(255, 255, 255));
        contactLabel.setText("Set Text");
        participantProfilePanel.add(contactLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 440, 30));

        genderLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        genderLabel.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel.setText("Set Text");
        participantProfilePanel.add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 440, 30));

        unilabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        unilabel.setForeground(new java.awt.Color(255, 255, 255));
        unilabel.setText("Set Text");
        participantProfilePanel.add(unilabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 440, 30));

        tshirtLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        tshirtLabel.setForeground(new java.awt.Color(255, 255, 255));
        tshirtLabel.setText("Set Text");
        participantProfilePanel.add(tshirtLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 440, 30));

        addressLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        addressLabel.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel.setText("Set Text");
        participantProfilePanel.add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 440, 30));

        nameLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Set Text");
        participantProfilePanel.add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 440, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/profile.png"))); // NOI18N
        participantProfilePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jTabbedPane1.addTab("tab2", participantProfilePanel);

        coachesPanel.setOpaque(false);
        coachesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 51, 51));
        jLabel16.setText("Coaches");
        coachesPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 230, 60));

        coachTableScrollPane1.setOpaque(false);

        coachTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        coachTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "University", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        coachTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        coachTable.setOpaque(false);
        coachTable.setRowHeight(40);
        coachTable.setRowMargin(1);
        coachTable.getTableHeader().setResizingAllowed(false);
        coachTable.getTableHeader().setReorderingAllowed(false);
        coachTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coachTableMouseClicked(evt);
            }
        });
        coachTableScrollPane1.setViewportView(coachTable);
        coachTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        coachesPanel.add(coachTableScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 770, -1));

        coachProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        coachProfile.setText("Profile");
        coachProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachProfileActionPerformed(evt);
            }
        });
        coachesPanel.add(coachProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 130, 40));

        coachDelete.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        coachDelete.setText("Delete");
        coachDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coachDeleteActionPerformed(evt);
            }
        });
        coachesPanel.add(coachDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 630, 130, 40));

        jTabbedPane1.addTab("tab1", coachesPanel);

        universityPanel.setOpaque(false);
        universityPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("University");
        universityPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 290, 60));

        participantTableScrollPane2.setOpaque(false);

        universityTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        universityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "University", "Team Name", "Team Id", "Payment Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        universityTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        universityTable.setOpaque(false);
        universityTable.setRowHeight(40);
        universityTable.setRowMargin(1);
        universityTable.getTableHeader().setResizingAllowed(false);
        universityTable.getTableHeader().setReorderingAllowed(false);
        universityTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                universityTableMouseClicked(evt);
            }
        });
        participantTableScrollPane2.setViewportView(universityTable);
        universityTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        universityPanel.add(participantTableScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 770, -1));

        uniDelete.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        uniDelete.setText("Remove");
        uniDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uniDeleteActionPerformed(evt);
            }
        });
        universityPanel.add(uniDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 630, 130, 40));

        teamProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        teamProfile.setText("Team Details");
        teamProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamProfileActionPerformed(evt);
            }
        });
        universityPanel.add(teamProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 130, 40));

        jTabbedPane1.addTab("tab3", universityPanel);

        CoachProfilePanel.setOpaque(false);
        CoachProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Profile");
        CoachProfilePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 160, 40));

        emailLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        emailLabel1.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel1.setText("Set Text");
        CoachProfilePanel.add(emailLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 440, 30));

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 255, 255));
        jLabel18.setText("Full Name        :");
        CoachProfilePanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 140, 30));

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 255, 255));
        jLabel19.setText("Date of Birth   :");
        CoachProfilePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 140, 30));

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(153, 255, 255));
        jLabel20.setText("Contact            :");
        CoachProfilePanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 170, 30));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 255, 255));
        jLabel21.setText("University        :");
        CoachProfilePanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, 30));

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 255, 255));
        jLabel22.setText("Address            :");
        CoachProfilePanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 140, 30));

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 255, 255));
        jLabel23.setText("Email                :");
        CoachProfilePanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, 30));

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 255, 255));
        jLabel24.setText("Position           :");
        CoachProfilePanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, 140, 30));

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 255, 255));
        jLabel25.setText("T-Shirt              :");
        CoachProfilePanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 140, 30));

        dobLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        dobLabel1.setForeground(new java.awt.Color(255, 255, 255));
        dobLabel1.setText("Set Text");
        CoachProfilePanel.add(dobLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 440, 30));

        contactLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        contactLabel1.setForeground(new java.awt.Color(255, 255, 255));
        contactLabel1.setText("Set Text");
        CoachProfilePanel.add(contactLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 440, 30));

        positionLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        positionLabel.setForeground(new java.awt.Color(255, 255, 255));
        positionLabel.setText("Set Text");
        CoachProfilePanel.add(positionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 440, 30));

        unilabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        unilabel1.setForeground(new java.awt.Color(255, 255, 255));
        unilabel1.setText("Set Text");
        CoachProfilePanel.add(unilabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 440, 30));

        tshirtLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        tshirtLabel1.setForeground(new java.awt.Color(255, 255, 255));
        tshirtLabel1.setText("Set Text");
        CoachProfilePanel.add(tshirtLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 440, 30));

        addressLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        addressLabel1.setForeground(new java.awt.Color(255, 255, 255));
        addressLabel1.setText("Set Text");
        CoachProfilePanel.add(addressLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 440, 30));

        nameLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        nameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel1.setText("Set Text");
        CoachProfilePanel.add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 440, 30));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/profile.png"))); // NOI18N
        CoachProfilePanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, -1, -1));

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 255, 255));
        jLabel27.setText("Gender             :");
        CoachProfilePanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 140, 30));

        genderLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        genderLabel1.setForeground(new java.awt.Color(255, 255, 255));
        genderLabel1.setText("Set Text");
        CoachProfilePanel.add(genderLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 440, 30));

        jTabbedPane1.addTab("tab2", CoachProfilePanel);

        teamProfilePanel.setOpaque(false);
        teamProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Nirmala UI", 1, 48)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 51, 51));
        jLabel40.setText("My Team");
        teamProfilePanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 230, 60));

        viewTeamTeamId.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        viewTeamTeamId.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamTeamId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamTeamId.setText("Team_Id");
        teamProfilePanel.add(viewTeamTeamId, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 200, -1));

        viewTeamTeamName.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        viewTeamTeamName.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamTeamName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamTeamName.setText("Team Name");
        teamProfilePanel.add(viewTeamTeamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 490, -1));

        jLabel66.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 0));
        jLabel66.setText("Coach:");
        teamProfilePanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 100, -1));

        viewTeamCoachEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewTeamCoachEmail.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamCoachEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamCoachEmail.setText("Coach_email");
        teamProfilePanel.add(viewTeamCoachEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 290, -1));

        viewTeamCoachName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewTeamCoachName.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamCoachName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamCoachName.setText("Coach_name");
        teamProfilePanel.add(viewTeamCoachName, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 290, -1));

        viewTeamMember1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewTeamMember1.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamMember1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamMember1.setText("Member_name");
        teamProfilePanel.add(viewTeamMember1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 290, -1));

        viewTeamPaymentStatus.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        viewTeamPaymentStatus.setForeground(new java.awt.Color(153, 255, 255));
        viewTeamPaymentStatus.setText("Payment_Status");
        teamProfilePanel.add(viewTeamPaymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 150, -1));

        viewTeamMember2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewTeamMember2.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamMember2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamMember2.setText("Member_name");
        teamProfilePanel.add(viewTeamMember2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 290, -1));

        jLabel72.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 0));
        jLabel72.setText("Member - 2:");
        teamProfilePanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 150, -1));

        viewTeamMember3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        viewTeamMember3.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamMember3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamMember3.setText("Member_name");
        teamProfilePanel.add(viewTeamMember3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 290, -1));

        jLabel74.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 0));
        jLabel74.setText("Member - 3:");
        teamProfilePanel.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 150, -1));

        jLabel75.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 0));
        jLabel75.setText("Member - 1:");
        teamProfilePanel.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 150, -1));

        jLabel76.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 0));
        jLabel76.setText("Payment Status:");
        teamProfilePanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 150, -1));

        teamCompletePaymentBtn.setText("Complete Payment");
        teamProfilePanel.add(teamCompletePaymentBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 450, -1, -1));

        viewTeamUniversityName.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        viewTeamUniversityName.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamUniversityName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamUniversityName.setText("University_Name");
        teamProfilePanel.add(viewTeamUniversityName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 490, -1));

        viewTeamUniversityName2.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        viewTeamUniversityName2.setForeground(new java.awt.Color(255, 255, 255));
        viewTeamUniversityName2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewTeamUniversityName2.setText("Team ID:");
        teamProfilePanel.add(viewTeamUniversityName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 100, -1));

        jTabbedPane1.addTab("tab1", teamProfilePanel);

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

        participantsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/admin/participantsButton_1.png"))); // NOI18N
        participantsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                participantsButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                participantsButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                participantsButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                participantsButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                participantsButtonMouseReleased(evt);
            }
        });
        getContentPane().add(participantsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, -1));

        coachesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/admin/coachesButton_1.png"))); // NOI18N
        coachesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coachesButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coachesButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                coachesButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                coachesButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                coachesButtonMouseReleased(evt);
            }
        });
        getContentPane().add(coachesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        universityButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/admin/universityButton_1.png"))); // NOI18N
        universityButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                universityButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                universityButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                universityButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                universityButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                universityButtonMouseReleased(evt);
            }
        });
        getContentPane().add(universityButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, -1, -1));

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/admin/LogOutButton_1.png"))); // NOI18N
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutButtonMouseReleased(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, -1, -1));

        coachHomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buttons/instructor/ChomeButton_3.png"))); // NOI18N
        coachHomeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coachHomeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coachHomeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                coachHomeBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                coachHomeBtnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                coachHomeBtnMouseReleased(evt);
            }
        });
        getContentPane().add(coachHomeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, -1, -1));

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

    private void searchListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchListKeyPressed

    private void searchListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_searchListValueChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_searchListValueChanged

    private void participantsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantsButtonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(participntPanel);
    }//GEN-LAST:event_participantsButtonMouseClicked

    private void coachesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachesButtonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(coachesPanel);
    }//GEN-LAST:event_coachesButtonMouseClicked

    private void universityButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityButtonMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(universityPanel);
    }//GEN-LAST:event_universityButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        int opt = JOptionPane.showConfirmDialog(null, "Do you want to Log out?","Close",JOptionPane.YES_NO_OPTION);
        if(opt == 0) {
            this.setVisible(false);
            HomeFrame home = new HomeFrame(allParticipantInfo, allCoachInfo, allTeamInfo);
            home.setVisible(true);
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void participantsButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantsButtonMouseEntered
        // TODO add your handling code here:
        participantsButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/participantsButton_2.png")));
    }//GEN-LAST:event_participantsButtonMouseEntered

    private void participantsButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantsButtonMouseExited
        // TODO add your handling code here:
         participantsButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/participantsButton_1.png")));
    }//GEN-LAST:event_participantsButtonMouseExited

    private void participantsButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantsButtonMousePressed
        // TODO add your handling code here:
         participantsButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/participantsButton_3.png")));
    }//GEN-LAST:event_participantsButtonMousePressed

    private void participantsButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantsButtonMouseReleased
        // TODO add your handling code here:
         participantsButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/participantsButton_2.png")));
    }//GEN-LAST:event_participantsButtonMouseReleased

    private void coachesButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachesButtonMouseEntered
        // TODO add your handling code here:
       coachesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/coachesButton_2.png")));
    }//GEN-LAST:event_coachesButtonMouseEntered

    private void coachesButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachesButtonMouseExited
        // TODO add your handling code here:
        coachesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/coachesButton_1.png")));
    }//GEN-LAST:event_coachesButtonMouseExited

    private void coachesButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachesButtonMousePressed
        // TODO add your handling code here:
        coachesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/coachesButton_3.png")));
    }//GEN-LAST:event_coachesButtonMousePressed

    private void coachesButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachesButtonMouseReleased
        // TODO add your handling code here:
        coachesButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/coachesButton_2.png")));
    }//GEN-LAST:event_coachesButtonMouseReleased

    private void universityButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityButtonMouseEntered
        // TODO add your handling code here:
        universityButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/universityButton_2.png")));
    }//GEN-LAST:event_universityButtonMouseEntered

    private void universityButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityButtonMouseExited
        // TODO add your handling code here:
        universityButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/universityButton_1.png")));
    }//GEN-LAST:event_universityButtonMouseExited

    private void universityButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityButtonMousePressed
        // TODO add your handling code here:
        universityButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/universityButton_3.png")));
    }//GEN-LAST:event_universityButtonMousePressed

    private void universityButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityButtonMouseReleased
        // TODO add your handling code here:
        universityButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/universityButton_2.png")));
    }//GEN-LAST:event_universityButtonMouseReleased

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        // TODO add your handling code here:
        logoutButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/LogOutButton_2.png")));
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        // TODO add your handling code here: 
        logoutButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/LogOutButton_1.png")));
    }//GEN-LAST:event_logoutButtonMouseExited

    private void logoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMousePressed
        // TODO add your handling code here:
         logoutButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/LogOutButton_3.png")));
    }//GEN-LAST:event_logoutButtonMousePressed

    private void logoutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseReleased
        // TODO add your handling code here:
         logoutButton.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/LogOutButton_2.png")));
    }//GEN-LAST:event_logoutButtonMouseReleased

    private void coachTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_coachTableMouseClicked

    private void universityTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_universityTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_universityTableMouseClicked

    private void participantTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_participantTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_participantTableMouseClicked

    private void partProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partProfileActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)participantTable.getModel();
        int selectedRowIndex = participantTable.getSelectedRow();
        String id = model.getValueAt(selectedRowIndex, 2).toString();
        try {
            if(allParticipantInfo.containsKey(id))
            {
                setPartcipantValue(allParticipantInfo.get(id));
                jTabbedPane1.setSelectedComponent(participantProfilePanel);
            }
            else throw new HandleIdNotFoundException(id);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_partProfileActionPerformed

    private void partDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)participantTable.getModel();
        int selectedRowIndex = participantTable.getSelectedRow();
        String id = model.getValueAt(selectedRowIndex, 2).toString();
        try {
            if(allParticipantInfo.containsKey(id))
            {          
                allParticipantInfo.remove(id);
                SetParticipantTable();
                try {
                    ParticipantInfo pi = new ParticipantInfo(allParticipantInfo);
                    pi.writeData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Ocuured While Deleting", "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else throw new HandleIdNotFoundException(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_partDeleteActionPerformed

    private void coachProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachProfileActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)coachTable.getModel();
        int selectedRowIndex = coachTable.getSelectedRow();
        String id = model.getValueAt(selectedRowIndex, 2).toString();
        if(allCoachInfo.containsKey(id))
        {
            setCoachValue(allCoachInfo.get(id));
            jTabbedPane1.setSelectedComponent(CoachProfilePanel);
        }
    }//GEN-LAST:event_coachProfileActionPerformed

    private void coachDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coachDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)coachTable.getModel();
        int selectedRowIndex = coachTable.getSelectedRow();
        String id = model.getValueAt(selectedRowIndex, 2).toString();
        try {
            if(allCoachInfo.containsKey(id))
            {          
                allCoachInfo.remove(id);
                SetCoachTable();
                try {
                    CoachInfo ci = new CoachInfo(allCoachInfo);
                    ci.writeData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Ocuured While Deleting", "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else throw new WrongEmailException(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_coachDeleteActionPerformed

    private void uniDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uniDeleteActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)universityTable.getModel();
        int selectedRowIndex = universityTable.getSelectedRow();
        String id = model.getValueAt(selectedRowIndex, 2).toString();
        try {
            if(allTeamInfo.containsKey(id))
            {
                allTeamInfo.remove(id);
                SetUniversityTable();
                try {
                    TeamInfo ti = new TeamInfo(allTeamInfo);
                    ti.writeData();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error Ocuured While Deleting", "Database Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else throw new TeamNotFoundException(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_uniDeleteActionPerformed

    private void teamProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamProfileActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)universityTable.getModel();
        int selectedRowIndex = universityTable.getSelectedRow();
        String id = model.getValueAt(selectedRowIndex, 2).toString();
        if(allTeamInfo.containsKey(id))
        {
            setTeamValue(allTeamInfo.get(id));
            jTabbedPane1.setSelectedComponent(teamProfilePanel);
        }
    }//GEN-LAST:event_teamProfileActionPerformed

    private void coachHomeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachHomeBtnMouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedComponent(coachHomePanel);
    }//GEN-LAST:event_coachHomeBtnMouseClicked

    private void coachHomeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachHomeBtnMouseEntered
        // TODO add your handling code here:
         coachHomeBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/homeButton_2.png")));
    }//GEN-LAST:event_coachHomeBtnMouseEntered

    private void coachHomeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachHomeBtnMouseExited
        // TODO add your handling code here:
        coachHomeBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/homeButton_1.png")));
    }//GEN-LAST:event_coachHomeBtnMouseExited

    private void coachHomeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachHomeBtnMousePressed
        // TODO add your handling code here:
        coachHomeBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/homeButton_3.png")));
    }//GEN-LAST:event_coachHomeBtnMousePressed

    private void coachHomeBtnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coachHomeBtnMouseReleased
        // TODO add your handling code here:
        coachHomeBtn.setIcon(new ImageIcon(getClass().getResource("/images/buttons/admin/homeButton_2.png")));
    }//GEN-LAST:event_coachHomeBtnMouseReleased

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
            java.util.logging.Logger.getLogger(AdminModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JPanel CoachProfilePanel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JButton coachDelete;
    private javax.swing.JLabel coachHomeBtn;
    private javax.swing.JPanel coachHomePanel;
    private javax.swing.JButton coachProfile;
    private javax.swing.JTable coachTable;
    private javax.swing.JScrollPane coachTableScrollPane1;
    private javax.swing.JLabel coachesButton;
    private javax.swing.JPanel coachesPanel;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JLabel contactLabel1;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel dobLabel1;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailLabel1;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel genderLabel1;
    private javax.swing.JLabel handleLabel;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JButton partDelete;
    private javax.swing.JButton partProfile;
    private javax.swing.JPanel participantProfilePanel;
    private javax.swing.JTable participantTable;
    private javax.swing.JScrollPane participantTableScrollPane;
    private javax.swing.JScrollPane participantTableScrollPane2;
    private javax.swing.JLabel participantsButton;
    private javax.swing.JPanel participntPanel;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JList<String> searchList;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton teamCompletePaymentBtn;
    private javax.swing.JButton teamProfile;
    private javax.swing.JPanel teamProfilePanel;
    private javax.swing.JLabel tshirtLabel;
    private javax.swing.JLabel tshirtLabel1;
    private javax.swing.JButton uniDelete;
    private javax.swing.JLabel unilabel;
    private javax.swing.JLabel unilabel1;
    private javax.swing.JLabel universityButton;
    private javax.swing.JPanel universityPanel;
    private javax.swing.JTable universityTable;
    private javax.swing.JLabel viewTeamCoachEmail;
    private javax.swing.JLabel viewTeamCoachName;
    private javax.swing.JLabel viewTeamMember1;
    private javax.swing.JLabel viewTeamMember2;
    private javax.swing.JLabel viewTeamMember3;
    private javax.swing.JLabel viewTeamPaymentStatus;
    private javax.swing.JLabel viewTeamTeamId;
    private javax.swing.JLabel viewTeamTeamName;
    private javax.swing.JLabel viewTeamUniversityName;
    private javax.swing.JLabel viewTeamUniversityName2;
    // End of variables declaration//GEN-END:variables
}
