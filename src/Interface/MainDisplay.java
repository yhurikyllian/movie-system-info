/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Engine.InformationData;
import Engine.Login;
import Engine.Search;
import java.awt.Color;
import javax.swing.JTable;

/**
 *
 * @author Sora
 */
public class MainDisplay extends javax.swing.JFrame {
    
    private boolean member = false;
    private Engine.Login log;
    private Engine.Data data = new Engine.Data();
    private boolean isSelected = false;
    private String user = "";

    /**
     * Creates new form MainDisplay
     */
    public MainDisplay() {
        initComponents();
        
        setInterface(1, 0, 0, 0, 0, 0);
        data.setBar(1);
    }
    
    private void setInterface(int layerNew, int layerGenre, int layerList, int layerRank, int layerMylist, int layerLogin){
        if(layerNew == 1){
            jLayeredPane1.setVisible(true);
        } else{
            jLayeredPane1.setVisible(false);
        }
        
        if(layerGenre == 1){
            jLayeredPane2.setVisible(true);
        } else{
            jLayeredPane2.setVisible(false);
        }
        
        if(layerList == 1){
            jLayeredPane3.setVisible(true);
        } else{
            jLayeredPane3.setVisible(false);
        }
        
        if(layerRank == 1){
            jLayeredPane4.setVisible(true);
        } else{
            jLayeredPane4.setVisible(false);
        }
        
        if(layerMylist == 1){
            jLayeredPane6.setVisible(true);
        } else{
            jLayeredPane6.setVisible(false);
        }
        
        if(layerLogin == 1){
            lyrLogin.setVisible(true);
        } else{
            lyrLogin.setVisible(false);
        }
    }
    
    private void search(String text){
        new Search(tblRelease, "title", text);
        setInterface(1, 0, 0, 0, 0, 0);
    }
    
    private void searchGenre(String genre){
        switch(genre){
            case "romance":
                new Search(tblGenre, "genre", genre);
                break;
            case "action":
                new Search(tblGenre, "genre", genre);
                break;
            case "comedy":
                new Search(tblGenre, "genre", genre);
                break;
            case "fantasy":
                new Search(tblGenre, "genre", genre);
                break;
            case "sport":
                new Search(tblGenre, "genre", genre);
                break;
            
        }        
    }
    
    private void authentication(boolean login){
        if(login){
            log = new Engine.Login(txtUser.getText() , txtPass.getText());
        
            if(log.getStatus() == true){
                user = txtUser.getText();
                lblLogin.setText("Welcome " + user + " !");
                lblRegister.setText("Log out");
                lblRegister.setForeground(Color.red);
                lyrLogin.setVisible(false);
                member = true;
                //log.setStatus(false);
                setInterface(0, 0, 1, 0, 1, 0);
            } else {
                lblAuthentication.setText("User name and Password doesn't match. Please try again!");
                member = false;
            }
        } else {
            member = false;
            setInterface(0, 0, 1, 0, 0, 1);
            user = "";
            lblLogin.setText("Log in");
            lblRegister.setText("Register");
            lblRegister.setForeground(new Color(0, 150, 0));
        }
        
    }
    
    
    private JTable getTable(){
        //jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        JTable table = new JTable();
        switch(data.getBar()){
            case 1:
                table = tblRelease;
                //System.out.println("wow : " + tblRelease.getName());
                return table;
                //break;
            case 2:
                table = tblGenre;
                return table;
                //break;
            case 3:
                table = tblRank;
                return table;
                //break;
            case 4:
                table = tblMyList;
                return table;
                //break;
        }
        //System.out.println("table :" + table.getName());
        return table;
    }
    
    private String getActiveRow(JTable table){
        String row = null;
        try{
            row = "" + table.getModel().getValueAt(table.getSelectedRow(), 0);
            
            return row;
        } catch(Exception e){
            //System.out.println("Title haven't selected!");
        }
        
        //setEnableDescription(true);
        //System.out.println("row :" + row);
        return row;
    }
    
    private void setEnableDescription(boolean enable){
        mnDescription.setEnabled(enable);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("anime?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        listQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT l FROM List l");
        listList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : listQuery.getResultList();
        lblNewRelease = new javax.swing.JLabel();
        lblGenre = new javax.swing.JLabel();
        lblRank = new javax.swing.JLabel();
        lblMyList = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        lblRegister = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRelease = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        chkRomance = new javax.swing.JCheckBox();
        chkAction = new javax.swing.JCheckBox();
        chkSport = new javax.swing.JCheckBox();
        chkFantasy = new javax.swing.JCheckBox();
        chkComedy = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGenre = new javax.swing.JTable();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblRank = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        lyrLogin = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        lblAuthentication = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblMyList = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnDescription = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Anime Info v.1.3");
        setResizable(false);

        lblNewRelease.setText("New Release");
        lblNewRelease.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNewReleaseMouseClicked(evt);
            }
        });

        lblGenre.setText("Genre");
        lblGenre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenreMouseClicked(evt);
            }
        });

        lblRank.setText("Rank");
        lblRank.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRankMouseClicked(evt);
            }
        });

        lblMyList.setText("My List");
        lblMyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMyListMouseClicked(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblLogin.setForeground(new java.awt.Color(0, 102, 204));
        lblLogin.setText("Log in");
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblLoginMouseExited(evt);
            }
        });

        lblRegister.setForeground(new java.awt.Color(0, 153, 0));
        lblRegister.setText("Register");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegisterMouseExited(evt);
            }
        });

        tblRelease.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listList, tblRelease);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${code}"));
        columnBinding.setColumnName("Code");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${title}"));
        columnBinding.setColumnName("Title");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${episodes}"));
        columnBinding.setColumnName("Episodes");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${year}"));
        columnBinding.setColumnName("Year");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${producers}"));
        columnBinding.setColumnName("Producers");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${genre}"));
        columnBinding.setColumnName("Genre");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${rating}"));
        columnBinding.setColumnName("Rating");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);

        jScrollPane2.setViewportView(tblRelease);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        chkRomance.setText("Romance");
        chkRomance.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkRomanceItemStateChanged(evt);
            }
        });
        chkRomance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkRomanceActionPerformed(evt);
            }
        });

        chkAction.setText("Action");
        chkAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkActionActionPerformed(evt);
            }
        });

        chkSport.setText("Sport");
        chkSport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkSportActionPerformed(evt);
            }
        });

        chkFantasy.setText("Fantasy");
        chkFantasy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkFantasyActionPerformed(evt);
            }
        });

        chkComedy.setText("Comedy");
        chkComedy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkComedyActionPerformed(evt);
            }
        });

        tblGenre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Title", "Episodes", "Year", "Producers", "Genre", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblGenre);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkRomance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkFantasy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkComedy)
                .addGap(0, 438, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkRomance)
                    .addComponent(chkAction)
                    .addComponent(chkSport)
                    .addComponent(chkFantasy)
                    .addComponent(chkComedy))
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jLayeredPane2.setLayer(chkRomance, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(chkAction, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(chkSport, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(chkFantasy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(chkComedy, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblRank.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Title", "Episodes", "Year", "Producers", "Genre", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblRank);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 751, Short.MAX_VALUE)
            .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 289, Short.MAX_VALUE)
            .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );
        jLayeredPane4.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setText("User Name :");

        jLabel8.setText("Password :");

        txtPass.setText("jPasswordField1");

        lblAuthentication.setText("Please log in to activate this feature.");

        btnLogin.setText("Log In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jButton1.setText("Cancel");

        javax.swing.GroupLayout lyrLoginLayout = new javax.swing.GroupLayout(lyrLogin);
        lyrLogin.setLayout(lyrLoginLayout);
        lyrLoginLayout.setHorizontalGroup(
            lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyrLoginLayout.createSequentialGroup()
                .addContainerGap(252, Short.MAX_VALUE)
                .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lyrLoginLayout.createSequentialGroup()
                        .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(lyrLoginLayout.createSequentialGroup()
                                .addComponent(btnLogin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(212, 212, 212))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lyrLoginLayout.createSequentialGroup()
                        .addComponent(lblAuthentication)
                        .addGap(266, 266, 266))))
        );
        lyrLoginLayout.setVerticalGroup(
            lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lyrLoginLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblAuthentication)
                .addGap(18, 18, 18)
                .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(36, 36, 36)
                .addGroup(lyrLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(jButton1))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        lyrLogin.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyrLogin.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyrLogin.setLayer(txtUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyrLogin.setLayer(txtPass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyrLogin.setLayer(lblAuthentication, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyrLogin.setLayer(btnLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        lyrLogin.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        tblMyList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Title", "Episodes", "Year", "Producers", "Genre", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tblMyList);

        jLabel5.setText("Movie you have watched so far");

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane6.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lyrLogin)
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane6))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lyrLogin)
            .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane6))
        );
        jLayeredPane3.setLayer(lyrLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu1.setText("File");

        mnDescription.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        mnDescription.setText("Movie Description");
        mnDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDescriptionActionPerformed(evt);
            }
        });
        jMenu1.add(mnDescription);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Delete Movie");
        jMenuItem4.setEnabled(false);
        jMenu1.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setText("Tutorial");
        jMenuItem2.setEnabled(false);
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("About");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblNewRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblRank, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblMyList, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)
                        .addGap(13, 13, 13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRegister)))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(jLayeredPane1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane2))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane4))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNewRelease, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblRank, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMyList, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRegister)
                            .addComponent(lblLogin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblGenreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenreMouseClicked
        // TODO add your handling code here:
        /*jLayeredPane2.setVisible(true);
        jLayeredPane1.setVisible(false);
        jLayeredPane3.setVisible(false);
        jLayeredPane4.setVisible(false); */
        setInterface(0, 1, 0, 0, 0, 0);
        data.setBar(2);
    }//GEN-LAST:event_lblGenreMouseClicked

    private void lblNewReleaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNewReleaseMouseClicked
        // TODO add your handling code here:
        /*jLayeredPane1.setVisible(true);
        jLayeredPane2.setVisible(false);
        jLayeredPane3.setVisible(false);
        jLayeredPane4.setVisible(false);*/
        setInterface(1, 0, 0, 0, 0, 0);
        data.setBar(1);
    }//GEN-LAST:event_lblNewReleaseMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        authentication(true);
        new Search(log.getStatus(), tblMyList, log.getUser());
        data.setBar(4);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void lblRankMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRankMouseClicked
        // TODO add your handling code here:
        /*jLayeredPane1.setVisible(false);
        jLayeredPane2.setVisible(false);
        jLayeredPane3.setVisible(true);
        jLayeredPane4.setVisible(false); */
        setInterface(0, 0, 0, 1, 0, 0);
        data.setBar(3);
        new Search(tblRank);
    }//GEN-LAST:event_lblRankMouseClicked

    private void lblMyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMyListMouseClicked
        // TODO add your handling code here:        
        if(member==true){
            setInterface(0, 0, 1, 0, 1, 0);
            data.setBar(4);
        } else{
            setInterface(0, 0, 1, 0, 0, 1);
        }
    }//GEN-LAST:event_lblMyListMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        search(txtSearch.getText());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void chkRomanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkRomanceActionPerformed
        // TODO add your handling code here:
        
        if(chkRomance.isSelected() == true){
            searchGenre("romance");
        }
    }//GEN-LAST:event_chkRomanceActionPerformed

    private void chkRomanceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkRomanceItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chkRomanceItemStateChanged

    private void chkActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkActionActionPerformed
        // TODO add your handling code here:
        if(chkAction.isSelected() == true){
            searchGenre("action");
        }
    }//GEN-LAST:event_chkActionActionPerformed

    private void chkSportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkSportActionPerformed
        // TODO add your handling code here:
        if(chkSport.isSelected() == true){
            searchGenre("sport");
        }
    }//GEN-LAST:event_chkSportActionPerformed

    private void chkFantasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkFantasyActionPerformed
        // TODO add your handling code here:
        if(chkFantasy.isSelected() == true){
            searchGenre("fantasy");
        }
    }//GEN-LAST:event_chkFantasyActionPerformed

    private void chkComedyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkComedyActionPerformed
        // TODO add your handling code here:
        if(chkComedy.isSelected() == true){
            searchGenre("comedy");
        }
    }//GEN-LAST:event_chkComedyActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        // TODO add your handling code here:
        if(member != true){
            setInterface(0, 0, 1, 0, 0, 1);
        }
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        // TODO add your handling code here:
        log = new Login();
        if(member == true){
            authentication(false);
            member = false;
        } else{
            new Register(this, true).setVisible(true);
        }
        
        
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void lblLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseEntered
        // TODO add your handling code here:
        lblLogin.setForeground(new Color(0,153,255));
    }//GEN-LAST:event_lblLoginMouseEntered

    private void lblLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseExited
        // TODO add your handling code here:
        lblLogin.setForeground(new Color(0,102,204));
    }//GEN-LAST:event_lblLoginMouseExited

    private void lblRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseEntered
        // TODO add your handling code here:
        lblRegister.setForeground(new Color(51,204,0));
    }//GEN-LAST:event_lblRegisterMouseEntered

    private void lblRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseExited
        // TODO add your handling code here:
        lblRegister.setForeground(new Color(0,153,0));
    }//GEN-LAST:event_lblRegisterMouseExited

    private void mnDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDescriptionActionPerformed
        // TODO add your handling code here:
        //int row = Integer.parseInt(getActiveRow(getTable()));
        //System.out.println("row :" + getActiveRow(getTable()));
        if(getActiveRow(getTable()) != null){
            String query = "SELECT code, title, episodes, year, producers, genre, rating, description FROM list where code = '" + getActiveRow(getTable()) + "';" ;
            new Search(this, query, user);
        }
        
    }//GEN-LAST:event_mnDescriptionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new AboutUs(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnSearch;
    private javax.swing.JCheckBox chkAction;
    private javax.swing.JCheckBox chkComedy;
    private javax.swing.JCheckBox chkFantasy;
    private javax.swing.JCheckBox chkRomance;
    private javax.swing.JCheckBox chkSport;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAuthentication;
    private javax.swing.JLabel lblGenre;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMyList;
    private javax.swing.JLabel lblNewRelease;
    private javax.swing.JLabel lblRank;
    private javax.swing.JLabel lblRegister;
    private java.util.List<DataBase.List> listList;
    private javax.persistence.Query listQuery;
    private javax.swing.JLayeredPane lyrLogin;
    private javax.swing.JMenuItem mnDescription;
    private javax.swing.JTable tblGenre;
    private javax.swing.JTable tblMyList;
    private javax.swing.JTable tblRank;
    private javax.swing.JTable tblRelease;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUser;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
