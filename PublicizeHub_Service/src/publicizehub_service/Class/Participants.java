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
public class Participants {
    private static int numOfStudent;
    private static int numOfTeacher;
    private static int numCome;

    public static int getNumOfStudent() {
        return numOfStudent;
    }

    public static void setNumOfStudent(int numOfStudent) {
        Participants.numOfStudent = numOfStudent;
    }

    public static int getNumOfTeacher() {
        return numOfTeacher;
    }

    public static void setNumOfTeacher(int numOfTeacher) {
        Participants.numOfTeacher = numOfTeacher;
    }

    public static int getNumCome() {
        return numCome;
    }

    public static void setNumCome(int numCome) {
        Participants.numCome = numCome;
    }

}
