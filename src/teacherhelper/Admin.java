/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author ViSion
 */
public class Admin extends User {

    public Admin(String name, String lastname, String phone, String username, String password, String userType) {
        super(name, lastname, phone, username, password, userType);
    }

    public void addUser(String name, String lastname, String phone, String username, String password, String userType) {
        try {
            JdbcSingleton.getInstance().insertUser(name, lastname, phone, username, password, userType);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteUser(int id, JFrame frame) throws SQLException {
        JdbcSingleton.getInstance().deleteUserById(id, frame);
    }

    public void updateUser(int id, String name, String lastName, String phone, String username, String password, String userType, AdminGui frame) throws SQLException {
        JdbcSingleton.getInstance().updateUser(id, name, lastName, phone, username, password, userType, frame);

    }

    public void addSubject(String subjectName, int credits) {
        try {
            JdbcSingleton.getInstance().insertSubject(subjectName, credits);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteSubject(int id, JFrame frame) throws SQLException {
        JdbcSingleton.getInstance().deleteSubjectById(id, frame);
    }

    public void updateSubject(int id, String subjectName, String subjectCredits, AdminGui frame) throws SQLException {
        JdbcSingleton.getInstance().updateSubject(id, subjectName, subjectCredits, frame);

    }

}
