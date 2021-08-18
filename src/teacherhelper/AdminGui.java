/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ViSion
 */
public class AdminGui extends javax.swing.JFrame {

    /**
     * Creates new form UserCreationGui
     */

    private Admin admin;
    public AdminGui(User user) {
        admin=(Admin)user;
        initComponents();
        try {
            loadView();
        } catch (SQLException ex) {
            Logger.getLogger(AdminGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadView() throws SQLException{
        jTable.setModel(JdbcSingleton.getInstance().getALLUsers(jTable.getModel()));
    }
    
    public boolean allInfoAvailable(){
        return(!(nameTf.getText().equals("")||lastNameTf.getText().equals("")||phoneTf.getText().equals("")||userNameTf.getText().equals("")||new String(passwordJpf.getPassword()).equals("")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        manageUserPnl = new javax.swing.JPanel();
        userCreationLbl = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        userInfoPnl = new javax.swing.JPanel();
        nameLbl = new javax.swing.JLabel();
        nameTf = new javax.swing.JTextField();
        lastNameLbl = new javax.swing.JLabel();
        lastNameTf = new javax.swing.JTextField();
        phoneLbl = new javax.swing.JLabel();
        phoneTf = new javax.swing.JTextField();
        userNameLbl = new javax.swing.JLabel();
        userNameTf = new javax.swing.JTextField();
        passwordLbl = new javax.swing.JLabel();
        passwordJpf = new javax.swing.JPasswordField();
        userTypeLbl = new javax.swing.JLabel();
        userTypeCb = new javax.swing.JComboBox<>();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        manageSubjectsPnl = new javax.swing.JPanel();
        editProfilePnl = new javax.swing.JPanel();
        changePasswordPnl = new javax.swing.JPanel();
        logoutPnl = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Creation");

        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        userCreationLbl.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        userCreationLbl.setText("USER CREATION");

        saveBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        editBtn.setText("EDIT");

        clearBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        clearBtn.setText("CLEAR");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        userInfoPnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        nameLbl.setText("Name");

        nameTf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        lastNameLbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lastNameLbl.setText("Last Name");

        lastNameTf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        phoneLbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        phoneLbl.setText("Phone");

        phoneTf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        userNameLbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        userNameLbl.setText("UserName");

        userNameTf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        passwordLbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        passwordLbl.setText("Password");

        passwordJpf.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N

        userTypeLbl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        userTypeLbl.setText("User Type");

        userTypeCb.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        userTypeCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Teacher", "Student" }));

        javax.swing.GroupLayout userInfoPnlLayout = new javax.swing.GroupLayout(userInfoPnl);
        userInfoPnl.setLayout(userInfoPnlLayout);
        userInfoPnlLayout.setHorizontalGroup(
            userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPnlLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(phoneLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameLbl)
                        .addComponent(lastNameLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(userNameLbl)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTypeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userNameTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordJpf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTypeCb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        userInfoPnlLayout.setVerticalGroup(
            userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInfoPnlLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLbl)
                    .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLbl)
                    .addComponent(lastNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLbl)
                    .addComponent(phoneTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLbl)
                    .addComponent(userNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLbl)
                    .addComponent(passwordJpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(userInfoPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userTypeLbl)
                    .addComponent(userTypeCb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "LAST NAME", "PHONE NUMBER", "USER NAME", "USER TYPE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(jTable);

        javax.swing.GroupLayout manageUserPnlLayout = new javax.swing.GroupLayout(manageUserPnl);
        manageUserPnl.setLayout(manageUserPnlLayout);
        manageUserPnlLayout.setHorizontalGroup(
            manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
            .addGroup(manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(manageUserPnlLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(manageUserPnlLayout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(userCreationLbl))
                        .addGroup(manageUserPnlLayout.createSequentialGroup()
                            .addComponent(userInfoPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(manageUserPnlLayout.createSequentialGroup()
                            .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        manageUserPnlLayout.setVerticalGroup(
            manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
            .addGroup(manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(manageUserPnlLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(userCreationLbl)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(userInfoPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(20, 20, 20)
                    .addGroup(manageUserPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveBtn)
                        .addComponent(deleteBtn)
                        .addComponent(editBtn)
                        .addComponent(clearBtn))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Manage Users", manageUserPnl);

        javax.swing.GroupLayout manageSubjectsPnlLayout = new javax.swing.GroupLayout(manageSubjectsPnl);
        manageSubjectsPnl.setLayout(manageSubjectsPnlLayout);
        manageSubjectsPnlLayout.setHorizontalGroup(
            manageSubjectsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
        );
        manageSubjectsPnlLayout.setVerticalGroup(
            manageSubjectsPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Manage Subjects", manageSubjectsPnl);

        javax.swing.GroupLayout editProfilePnlLayout = new javax.swing.GroupLayout(editProfilePnl);
        editProfilePnl.setLayout(editProfilePnlLayout);
        editProfilePnlLayout.setHorizontalGroup(
            editProfilePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
        );
        editProfilePnlLayout.setVerticalGroup(
            editProfilePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Edit Profile", editProfilePnl);

        javax.swing.GroupLayout changePasswordPnlLayout = new javax.swing.GroupLayout(changePasswordPnl);
        changePasswordPnl.setLayout(changePasswordPnlLayout);
        changePasswordPnlLayout.setHorizontalGroup(
            changePasswordPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
        );
        changePasswordPnlLayout.setVerticalGroup(
            changePasswordPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Change Password", changePasswordPnl);

        javax.swing.GroupLayout logoutPnlLayout = new javax.swing.GroupLayout(logoutPnl);
        logoutPnl.setLayout(logoutPnlLayout);
        logoutPnlLayout.setHorizontalGroup(
            logoutPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
        );
        logoutPnlLayout.setVerticalGroup(
            logoutPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Logout", logoutPnl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
      
        if(allInfoAvailable()){
            try {
                if(JdbcSingleton.getInstance().searchUser(userNameTf.getText())){
                    JOptionPane.showMessageDialog(this, "Username Already Exist Choose Another");
                }
                else{
                    
                    admin.addUser(nameTf.getText(), lastNameTf.getText(), phoneTf.getText(), userNameTf.getText(), new String(passwordJpf.getPassword()), userTypeCb.getSelectedItem().toString());
                    JOptionPane.showMessageDialog(this, "User Successfuly Created");
                    ResultSet rs=JdbcSingleton.getInstance().getUser(userNameTf.getText());
                    DefaultTableModel model=(DefaultTableModel)jTable.getModel();
                    while(rs.next()){
                    model.addRow(new Object[]{rs.getString("id"),rs.getString("name"),rs.getString("lastname"),rs.getString("phone"),
                    rs.getString("username"),rs.getString("userType")});
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Some Informations are Missing");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
      if(jTabbedPane1.getSelectedIndex()==4){
          this.dispose();
          new LoginGui().setVisible(true);
      }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
       DefaultTableModel model=(DefaultTableModel)jTable.getModel();
       int selectedIndex=jTable.getSelectedRow();
       nameTf.setText(jTable.getValueAt(selectedIndex, 1).toString());
       lastNameTf.setText(jTable.getValueAt(selectedIndex, 2).toString());
       phoneTf.setText(jTable.getValueAt(selectedIndex, 3).toString());
       userNameTf.setText(jTable.getValueAt(selectedIndex, 4).toString());
       userTypeCb.setSelectedItem(jTable.getValueAt(selectedIndex, 5).toString());
    }//GEN-LAST:event_jTableMouseClicked

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        nameTf.setText("");
        lastNameTf.setText("");
        phoneTf.setText("");
        userNameTf.setText("");
        passwordJpf.setText("");
        userTypeCb.setSelectedIndex(-1);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int selectedIndex=jTable.getSelectedRow();
        try {
            JdbcSingleton.getInstance().deleteUserById(Integer.parseInt(jTable.getValueAt(selectedIndex, 0).toString()), this);
            DefaultTableModel model=(DefaultTableModel)jTable.getModel();
            model.setRowCount(0);
            loadView();
             nameTf.setText("");
        lastNameTf.setText("");
        phoneTf.setText("");
        userNameTf.setText("");
        passwordJpf.setText("");
        userTypeCb.setSelectedIndex(-1);
        } catch (SQLException ex) {
            Logger.getLogger(AdminGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel changePasswordPnl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel editProfilePnl;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JTextField lastNameTf;
    private javax.swing.JPanel logoutPnl;
    private javax.swing.JPanel manageSubjectsPnl;
    private javax.swing.JPanel manageUserPnl;
    private javax.swing.JLabel nameLbl;
    private javax.swing.JTextField nameTf;
    private javax.swing.JPasswordField passwordJpf;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JLabel phoneLbl;
    private javax.swing.JTextField phoneTf;
    private javax.swing.JButton saveBtn;
    private javax.swing.JLabel userCreationLbl;
    private javax.swing.JPanel userInfoPnl;
    private javax.swing.JLabel userNameLbl;
    private javax.swing.JTextField userNameTf;
    private javax.swing.JComboBox<String> userTypeCb;
    private javax.swing.JLabel userTypeLbl;
    // End of variables declaration//GEN-END:variables
}