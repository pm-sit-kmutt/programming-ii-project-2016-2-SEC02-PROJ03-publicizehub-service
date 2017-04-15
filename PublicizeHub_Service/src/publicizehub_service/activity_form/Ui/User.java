/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.activity_form.Ui;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author นัน
 */
public class User {
    private static String username = "57130500102";
    private static String id;
    private static String firstName;
    private static String lastName;
    private static String faculty;
    private static int status = 0;

    public User() {
    }
    
    public User(ResultSet rs) throws SQLException{
        username = rs.getString("username");
        id = rs.getString("id");
        firstName = rs.getString("firstName");
        lastName = rs.getString("lastName");
        status = rs.getInt("status");
    }

    public static String getUsername() {
        return username;
    }

    public static String getId() {
        return id;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getFaculty() {
        return faculty;
    }

    public static int getStatus() {
        return status;
    }
    
    
    
}
