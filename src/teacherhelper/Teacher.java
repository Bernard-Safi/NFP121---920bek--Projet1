/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.SQLException;
import javax.swing.JFrame;

/**
 *
 * @author ViSion
 */
public class Teacher extends User {

    public Teacher(String name, String lastname, String phone, String username, String password, String userType) {
        super(name, lastname, phone, username, password, userType);
    }

    public void SubjectChoice(int userId, int subjectId) throws SQLException {
        JdbcSingleton.getInstance().chooseSubject(userId, subjectId);
    }

    public void subjectRemove(int userId, int subjectId, TeacherGui teacherGui) throws SQLException {
        JdbcSingleton.getInstance().removeSubject(userId, subjectId, teacherGui);
    }

    public void addProject(int subjectId, String name, String dueDate, String projectLink) throws SQLException {
        JdbcSingleton.getInstance().insertProject(subjectId, name, dueDate, projectLink);
    }

    public void editProject(int projectId, String name, String dueDate, String projectLink, JFrame frame) throws SQLException {
        JdbcSingleton.getInstance().updateProject(projectId, name, dueDate, projectLink, frame);
    }

    public void removeProject(int projectId, JFrame frame) throws SQLException {
        JdbcSingleton.getInstance().deleteProjectById(projectId, frame);
    }
}
