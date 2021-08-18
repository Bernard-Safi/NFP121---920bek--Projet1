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
                           exist=true;
 
                           new AdminGui(user).setVisible(true);
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
          String searchUser = "DELETE FROM users WHERE id = ?";
            PreparedStatement pstmt = c.prepareStatement(searchUser);
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
          String searchUser = "UPDATE users set name = ?,lastname = ?, phone = ?, username = ?, password = ?, userType= ? where id = ?";
            PreparedStatement pstmt = c.prepareStatement(searchUser);
            pstmt.setString(1, name);
            pstmt.setString(2, lastName);
            pstmt.setString(3, phone);
            pstmt.setString(4, username);
            pstmt.setString(5, password);
            pstmt.setString(6, userType);
            pstmt.setInt(7, id);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "User Successfuly Deleted");
      
      }
     }

    public DefaultTableModel getALLUsers(TableModel model) throws SQLException{
         DefaultTableModel mod=(DefaultTableModel)model;
        if(model.getRowCount()<=0){
        Connection c = null;
     c = getConnection();
     ResultSet rs = null;
    
        if(c!=null){

            String loadUsers = "SELECT * FROM users";
            PreparedStatement pstmt = c.prepareStatement(loadUsers);
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
}
