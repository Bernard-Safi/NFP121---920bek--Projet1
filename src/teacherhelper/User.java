/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    User(int id,String name,String lastname,String phone,String username,String password,String userType){
         setId(id);
         setName(name);
         setLastName(lastname);
         setPhone(phone);
         setUsername(username);
         setPassword(password);
         setUserType(userType);
    }
      User(String name,String lastname,String phone,String username,String password,String userType){
         setName(name);
         setLastName(lastname);
         setPhone(phone);
         setUsername(username);
         setPassword(password);
         setUserType(userType);
    }
    

 
    public int getId(){
        return this.id;
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
    
}
