/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.SQLException;

/**
 *
 * @author ViSion
 */
public class Student extends User {

    public Student(String name, String lastname, String phone, String username, String password, String userType) {
        super(name, lastname, phone, username, password, userType);
    }

    public void SubjectChoice(int userId, int subjectId) throws SQLException {
        JdbcSingleton.getInstance().chooseSubject(userId, subjectId);
    }

    public void subjectRemove(int userId, int subjectId, StudentGui studentGui) throws SQLException {
        JdbcSingleton.getInstance().removeSubject(userId, subjectId, studentGui);
    }

    public void submitProject(int userId, int projectId, String link) throws SQLException {
        JdbcSingleton.getInstance().submitProject(userId, projectId, link);
    }

}
