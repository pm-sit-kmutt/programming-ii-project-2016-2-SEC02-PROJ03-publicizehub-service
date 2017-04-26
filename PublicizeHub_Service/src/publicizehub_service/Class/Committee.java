/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;

/**
 *
 * @author นัน
 */
public class Committee {
    private static String studentId; 
    private static String name;
    private static String faculty;
    private static String job;

    public static String getStudentId() {
        return studentId;
    }

    public static void setStudentId(String studentId) {
        Committee.studentId = studentId;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Committee.name = name;
    }

    public static String getFaculty() {
        return faculty;
    }

    public static void setFaculty(String faculty) {
        Committee.faculty = faculty;
    }

    public static String getJob() {
        return job;
    }

    public static void setJob(String job) {
        Committee.job = job;
    }
    
    
}
