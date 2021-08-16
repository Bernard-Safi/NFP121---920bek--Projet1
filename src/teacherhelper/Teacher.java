/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

/**
 *
 * @author ViSion
 */
public class Teacher extends User{
    
    public Teacher(int id, String name, String lastname, String phone, String username, String password, String userType) {
        super(id, name, lastname, phone, username, password, userType);
    }
    public Teacher(String name, String lastname, String phone, String username, String password, String userType) {
        super(name, lastname, phone, username, password, userType);
    }

    
}
