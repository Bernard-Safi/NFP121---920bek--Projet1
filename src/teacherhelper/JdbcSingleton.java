/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacherhelper;

import java.sql.*;

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

    public void insert(String name, String lastName, String phone, String username, String password,
            String userType) throws SQLException {
        Connection c = null;
        Statement stmt = null;

        try {
            if(stmt!=null){
            c = getConnection();
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
          
        }

    }

}
