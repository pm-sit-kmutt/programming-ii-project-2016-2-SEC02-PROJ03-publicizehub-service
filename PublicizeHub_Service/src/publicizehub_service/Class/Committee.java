/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;

import javax.swing.JTable;

/**
 *
 * @author นัน
 */
public class Committee {
    private String studentId; 
    private String name;
    private String faculty;
    private String job;

    public Committee() {
    }

    public Committee(String studentId, String name, String faculty, String job) {
        this.studentId = studentId;
        this.name = name;
        this.faculty = faculty;
        this.job = job;
    }
    
    public static Committee[] jTableToArrayCommittee(JTable table){
        int tableRow = table.getRowCount();
        Committee[] arrayCommittee = new Committee[tableRow];
        for (int i = 0; i < tableRow; i++) {
            arrayCommittee[i] = new Committee(table.getValueAt(i, 0).toString(), table.getValueAt(i, 1).toString(),
                    table.getValueAt(i, 2).toString(), table.getValueAt(i, 3).toString());
        }
        return arrayCommittee;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Committee{" + "studentId=" + studentId + ", name=" + name + ", faculty=" + faculty + ", job=" + job + '}';
    }
    
    

    
    
}
