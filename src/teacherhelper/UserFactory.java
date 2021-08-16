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
public class UserFactory {
    public User getUser(int id, String name, String lastname, String phone, String username, String password, String userType){
        if(userType == null){
            return null;
        }
        else if(userType.equalsIgnoreCase("admin")){
            return new Admin(id, name, lastname, phone, username, password, userType);
        }
        else if(userType.equalsIgnoreCase("teacher")){
            return new Teacher(id, name, lastname, phone, username, password, userType);
        }
        else if(userType.equalsIgnoreCase("student")){
            return new Student(id, name, lastname, phone, username, password, userType);
        }
        return null;
    }
    public User getUser(String name, String lastname, String phone, String username, String password, String userType){
        if(userType == null){
            return null;
        }
        else if(userType.equalsIgnoreCase("admin")){
            return new Admin(name, lastname, phone, username, password, userType);
        }
        else if(userType.equalsIgnoreCase("teacher")){
            return new Teacher(name, lastname, phone, username, password, userType);
        }
        else if(userType.equalsIgnoreCase("student")){
            return new Student(name, lastname, phone, username, password, userType);
        }
        return null;
    }
}
