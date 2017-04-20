/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.activity_form.Ui;
/**
 *
 * @author นัน
 */
public class User {
    private static String username;
    private static String id;
    private static String firstName;
    private static String lastName;
    private static String faculty;
    private static int status;

    public User() {
    }
    
    public static void resetData(){
        username = "";
        id = "";
        firstName = "";
        lastName = "";
        faculty = "";
        status = 9;
    }
    
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        User.id = id;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static void setFirstName(String firstName) {
        User.firstName = firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    public static String getFaculty() {
        return faculty;
    }

    public static void setFaculty(String faculty) {
        User.faculty = faculty;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        User.status = status;
    }

    

    
    
}
