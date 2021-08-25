/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class JdbcSingleton {

    private static JdbcSingleton jdbc;

    private JdbcSingleton() {
    }

    public static JdbcSingleton getInstance() {
        if (jdbc == null) {
            jdbc = new JdbcSingleton();
        }
        return jdbc;
    }

    private static Connection getConnection() throws SQLException {
        Connection con = null;
try{
        

        con = DriverManager.getConnection("jdbc:mysql://localhost/teacherhelper", "root", "");
        return con;
}catch(SQLException e){    }
return con;
    }

    public void insertUser(String name, String lastName, String phone, String username, String password,
            String userType) throws SQLException {
        Connection c = null;

        try {
            c = getConnection();
            if(c!=null){
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO users (name,lastname,phone,username,password,usertype) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setString(4, username);
            pstmt.setString(5, password);
            pstmt.setString(6, userType);
            
            pstmt.executeUpdate();}
        } catch (SQLException e) {
            e.printStackTrace();
          
        }}
        
    public User validateLogin(String username,String password,JFrame frame) throws SQLException{
       
        Connection c = null;
     User user = null;
     boolean userName;
     c = getConnection();
        if(c!=null){

            String searchUser = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = c.prepareStatement(searchUser);
            pstmt.setString(1, username);
            ResultSet rs=pstmt.executeQuery();
            boolean exist=false;
            if(!rs.isBeforeFirst()){
                JOptionPane.showMessageDialog(frame, "UserName Does Not Exist");
                
        }
            else{
               while (rs.next()) {
                String pass= rs.getString("password");
                if(pass.equals(password)){
                    UserFactory factory=new UserFactory();
                   user=factory.getUser(rs.getString("name"),rs.getString("lastname"),
                           rs.getString("phone"),rs.getString("username"),rs.getString("password"),rs.getString("usertype"));
                   user.setId(rs.getInt("id"));
                           exist=true;
                           if(user instanceof Admin ){
                           new AdminGui(user).setVisible(true);
                          }
                           else if(user instanceof Teacher){
                                new TeacherGui(user).setVisible(true);
                           }
                            frame.dispose();
                   break;
                }

                }
  }
               if(exist==false){
                JOptionPane.showMessageDialog(frame, "Wrong Password Try Again");       
               }
            }
        return user;
    }
    
    public boolean searchUser(String username) throws SQLException{
         Connection c = null;
     c = getConnection();
     ResultSet rs = null;
        if(c!=null){

            String searchUser = "SELECT username FROM users WHERE username = ?";
            PreparedStatement pstmt = c.prepareStatement(searchUser);
            pstmt.setString(1, username);
            rs=pstmt.executeQuery();
        }
        return rs.next();
    }
    
     public ResultSet getUser(String username) throws SQLException{
         Connection c = null;
     c = getConnection();
     ResultSet rs = null;
        if(c!=null){

            String searchUser = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = c.prepareStatement(searchUser);
            pstmt.setString(1, username);
            rs=pstmt.executeQuery();
        }
        return rs;
    }
     
     public void deleteUserById(int id,JFrame frame) throws SQLException{
         Connection c = null;
     c = getConnection();
      if(c!=null){
          String deleteUser = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(deleteUser);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "User Successfuly Deleted");
      
      }
     }
     
     public void updateUser(int id,String name, String lastName, String phone, String username, String password,
            String userType,JFrame frame) throws SQLException{
                  Connection c = null;
     c = getConnection();
      if(c!=null){
          String updateUser = "UPDATE users set name = ?,lastname = ?, phone = ?, username = ?, userType= ? where id = ?";
            PreparedStatement pstmt = c.prepareStatement(updateUser);
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setString(4, username);
            pstmt.setString(5, userType);
            pstmt.setInt(6, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "User Successfuly edited");
      
      }
     }

    public DefaultTableModel getALLUsers(TableModel model,User user) throws SQLException{
         DefaultTableModel mod=(DefaultTableModel)model;
        if(model.getRowCount()<=0){
        Connection c = null;
     c = getConnection();
     ResultSet rs = null;
    
        if(c!=null){

            String loadUsers = "SELECT * FROM users WHERE username!=?";
            PreparedStatement pstmt = c.prepareStatement(loadUsers);
            pstmt.setString(1, user.getUsername());
            rs=pstmt.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
            while(rs.next()){
                Vector v= new Vector();
                for(int i=1;i<=columnCount;i++){
                    v.add(rs.getString("id"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("lastname"));
                    v.add(rs.getString("phone"));
                    v.add(rs.getString("username"));
                    v.add(rs.getString("userType"));
                }
                
                        mod.addRow(v);
            }
        }
        }
        return mod;
    }
    
    public String getPassword(int id) throws SQLException{
        Connection c = null;
     c = getConnection();
     ResultSet rs = null;
     String password=null;
    
        if(c!=null){

            String getPassword = "SELECT password FROM users where id = ?";
            PreparedStatement pstmt = c.prepareStatement(getPassword);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                password=rs.getString("password");
            }
        }
        return password;
    }
    
    public ResultSet loadProfile(User user) throws SQLException{
                 Connection c = null;
     c = getConnection();
     ResultSet rs = null;
        if(c!=null){

            String loadProfile = "SELECT name,lastname,phone,username FROM users WHERE username = ?";
            PreparedStatement pstmt = c.prepareStatement(loadProfile);
            pstmt.setString(1, user.getUsername());
            rs=pstmt.executeQuery();
            
        }
        return rs;
    }
    
    public void updateProfile(User user,String name,String lastname,String phone,String username,JFrame frame) throws SQLException{
               Connection c = null;
     c = getConnection();
      if(c!=null){
          String updateProfile = "UPDATE users set name = ?,lastname = ?, phone = ?, username = ? where username = ?";
            PreparedStatement pstmt = c.prepareStatement(updateProfile);
            pstmt.setString(1, name);
            pstmt.setString(2, lastname);
            pstmt.setString(3, phone);
            pstmt.setString(4, username);
            pstmt.setString(5, user.getUsername());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Profile Successfuly Updated");
      
      }
    }
    
    
    
        public boolean verifyOldPassword(User user,String password) throws SQLException{
               Connection c = null;
               ResultSet rs = null;
     c = getConnection();
      if(c!=null){
          String verifyPass = "Select password FROM users where username = ? and password= ?";
            PreparedStatement pstmt = c.prepareStatement(verifyPass);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, password);
            rs=pstmt.executeQuery();
      }
     return rs.next();
    }
        
            public void updatePassword(User user,String password,JFrame frame) throws SQLException{
               Connection c = null;
     c = getConnection();
      if(c!=null){
          String updateProfile = "UPDATE users set password = ? where username = ?";
            PreparedStatement pstmt = c.prepareStatement(updateProfile);
            pstmt.setString(1, password);
            pstmt.setString(2, user.getUsername());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Password Successfuly Updated");
      
      }
    }
            
            public boolean searchSubject(String subjectName) throws SQLException{
     Connection c = null;
     c = getConnection();
     ResultSet rs = null;
        if(c!=null){

            String searchSubject = "SELECT name FROM subject WHERE name = ?";
            PreparedStatement pstmt = c.prepareStatement(searchSubject);
            pstmt.setString(1, subjectName);
            rs=pstmt.executeQuery();
        }
        return rs.next();
    }
            
             public void insertSubject(String subjectName, int credits) throws SQLException {
        Connection c = null;

        try {
            c = getConnection();
            if(c!=null){
            PreparedStatement pstmt = c.prepareStatement("INSERT INTO subject (name,credits) VALUES (?,?)");
            pstmt.setString(1, subjectName);
            pstmt.setInt(2, credits);
            pstmt.executeUpdate();}
        } catch (SQLException e) {
            e.printStackTrace();
          
        }}
             
                  public ResultSet getSubject(String subjectName) throws SQLException{
         Connection c = null;
     c = getConnection();
     ResultSet rs = null;
        if(c!=null){

            String searchSubject = "SELECT * FROM subject WHERE name = ?";
            PreparedStatement pstmt = c.prepareStatement(searchSubject);
            pstmt.setString(1, subjectName);
            rs=pstmt.executeQuery();
        }
        return rs;
    }
                  
                  public DefaultTableModel getALLSubjects(TableModel model) throws SQLException{
         DefaultTableModel mod=(DefaultTableModel)model;
        if(model.getRowCount()<=0){
        Connection c = null;
     c = getConnection();
     ResultSet rs = null;
    
        if(c!=null){

            String loadSubjects = "SELECT * FROM subject";
            PreparedStatement pstmt = c.prepareStatement(loadSubjects);
            rs=pstmt.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnCount=rsmd.getColumnCount();
            while(rs.next()){
                Vector v= new Vector();
                for(int i=1;i<=columnCount;i++){
                    v.add(rs.getString("subjectId"));
                    v.add(rs.getString("name"));
                    v.add(rs.getString("credits"));
                }
                
                        mod.addRow(v);
            }
        }
        }
        return mod;
    }
                  
                       public void deleteSubjectById(int id,JFrame frame) throws SQLException{
         Connection c = null;
     c = getConnection();
      if(c!=null){
          String deleteSubject = "DELETE FROM subject WHERE subjectId = ?";
            PreparedStatement pstmt = c.prepareStatement(deleteSubject);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Subject Successfuly Deleted");
      
      }
     }
                       
                       public void updateSubject(int id,String subjectName, String subjectCredits,JFrame frame) throws SQLException{
                  Connection c = null;
     c = getConnection();
      if(c!=null){
          String updateSubject = "UPDATE subject set name = ?,credits = ? where subjectId = ?";
            PreparedStatement pstmt = c.prepareStatement(updateSubject);
            pstmt.setString(1, subjectName);
            pstmt.setString(2, subjectCredits);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Subject Successfuly edited");
      
      }
     }
                       
                                         public ResultSet getALLSubjectNames() throws SQLException{

        Connection c = null;
     c = getConnection();
     ResultSet rs = null;
    
        if(c!=null){

            String loadSubjects = "SELECT name FROM subject";
            PreparedStatement pstmt = c.prepareStatement(loadSubjects);
            rs=pstmt.executeQuery();
        }
        
        return rs;
    }
}
