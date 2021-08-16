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
public class Admin extends User{

    public Admin(int id, String name, String lastname, String phone, String username, String password, String userType) {
        super(id, name, lastname, phone, username, password, userType);
    }
    public Admin(String name, String lastname, String phone, String username, String password, String userType) {
        super(name, lastname, phone, username, password, userType);
    }
    
        public void addUser(User user){
        try {
            JdbcSingleton.getInstance().insert(user.getName(), user.getLastName(), user.getPhone(), user.getUsername(), user.getPassword(), user.getUserType());
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    
    
}
