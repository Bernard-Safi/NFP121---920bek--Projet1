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
public class TeacherHelper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginGui login=new LoginGui();
        login.setVisible(true);
//            AdminGui userCreation=new AdminGui();
//            userCreation.setVisible(true);
//        try {
//            
//            JdbcSingleton.getInstance().insert("bernard", "safi","03/145233","ViSion", "Password:123456789", "Admin");
//        } catch (SQLException ex) {
//            Logger.getLogger(TeacherHelper.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}