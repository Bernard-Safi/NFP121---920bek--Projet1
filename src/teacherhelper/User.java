/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ViSion
 */
abstract class User {
    private int id;
    private String name;
    private String lastname;
    private String phone;
    private String username;
    private String password;
    private String userType;
    
      User(String name,String lastname,String phone,String username,String password,String userType){
         setName(name);
         setLastName(lastname);
         setPhone(phone);
         setUsername(username);
         setPassword(password);
         setUserType(userType);
    }
      
    public static User userLogin(JTextField username,JPasswordField password,JFrame frame) throws SQLException{
      return JdbcSingleton.getInstance().validateLogin(username.getText(), new String(password.getPassword()),frame);
    }
    
    public void logout(JFrame frame){
          frame.dispose();
          new LoginGui().setVisible(true);
    }
    public void editProfile(User user,String name,String lastname,String phone,String username,JFrame frame) throws SQLException{
        JdbcSingleton.getInstance().updateProfile(user, name, lastname, phone, username, frame);
        
    }
    public void changePassword(User user,String password,JFrame frame) throws SQLException{
        JdbcSingleton.getInstance().updatePassword(user, password, frame);
    }
 
    
    public String getName(){
        return this.name;
    }
    public String getLastName(){
        return this.lastname;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserType(){
        return this.userType;
    }
    public int getId(){
        return this.id;
    }
    
    
    public void setId(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setLastName(String lastname){
        this.lastname=lastname;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setUserType(String userType){
        this.userType=userType;
    }
    
    
     public Memento saveStateToMemento(){
      return new Memento(password);
   }

   public void getStateFromMemento(Memento memento){
      password = memento.getState();
   }
}
