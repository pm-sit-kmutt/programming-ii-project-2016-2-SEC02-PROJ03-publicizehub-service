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
    private String username;
    private  String id;
    private  String firstName;
    private  String lastName;
    private  String faculty;
    private  int status = 0;

    public User() {
    }
    
    public User(ResultSet rs) throws SQLException{
        username = rs.getString("username");
        id = rs.getString("id");
        firstName = rs.getString("firstName");
        lastName = rs.getString("lastName");
        status = rs.getInt("status");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

   
    
    
}
