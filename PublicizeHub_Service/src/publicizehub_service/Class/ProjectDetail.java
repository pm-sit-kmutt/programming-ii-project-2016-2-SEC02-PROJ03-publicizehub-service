/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;
import java.sql.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author นัน
 */
public class ProjectDetail {
    private static int id;
    private static String responsible;
    private static String projectNameThai;
    private static String projectNameEnglish;
    private static String department;
    private static String Advisors;
    private static String rationale;
    private static int placeType;
    private static String placeLocation;
    private static int numOfStudent;
    private static int numCome;
    private static double budget;
    private static double cost;
    private static Date openTime;
    private static Date startTime;
    private static Date endTime;
    private static Date closeTime;
    private static int status;
    private static String objective;
    private static String expected;
    private static Committee[] committee;
    private static Comment[] comment;
    private static ProjectProcess[] process;
    private static Money[] money;
    
    public static boolean check(){
        if(responsible.isEmpty() || projectNameThai.isEmpty() || projectNameEnglish.isEmpty() || department.isEmpty() || Advisors.isEmpty() || rationale.isEmpty()
                || placeLocation.isEmpty() || numOfStudent == 0 || objective.isEmpty() || expected.isEmpty() || committee.length == 0 || process.length == 0 || money.length == 0){
            if(endTime.before(startTime)){
                JOptionPane.showMessageDialog(null, "คุณใส่ระยะเวลาในการดำเนินงาน ไม่ถูกต้อง");
            }else{
                JOptionPane.showMessageDialog(null, "คุณยังกรอกข้อมูลไม่ครบ");
            }
            return false;
        }else{
            return true;
        }
    }
    

    public static void printAll(){
        System.out.println("responsible: "+responsible); 
        System.out.println("projectNameThai: "+projectNameThai); 
        System.out.println("projectNameEnglish: "+projectNameEnglish); 
        System.out.println("department: "+department); 
        System.out.println("Advisors: "+Advisors); 
        System.out.println("rationale: "+rationale); 
        System.out.println("placeType: "+placeType); 
        System.out.println("placeLocation: "+placeLocation); 
        System.out.println("numOfStudent: "+numOfStudent); 
        System.out.println("numCome: "+numCome); 
        System.out.println("objective: "+objective); 
        System.out.println("expected: "+expected); 
        System.out.println("budget: "+budget); 
        System.out.println("cost: "+cost); 
        System.out.println("openTime: "+openTime); 
        System.out.println("startTime: "+startTime); 
        System.out.println("endTime: "+endTime); 
        System.out.println("closeTime: "+closeTime); 
        System.out.println("status: "+status); 
        
        System.out.println("comment: "+comment); 
        for (Committee committee1 : committee) {
            System.out.println(committee1);
        }
        for (ProjectProcess projectProcess : process) {
            System.out.println(projectProcess);
        }
        for (Money money : money) {
            System.out.println(money);
        }
    }
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        ProjectDetail.id = id;
    }

    public static String getResponsible() {
        return responsible;
    }

    public static void setResponsible(String responsible) {
        ProjectDetail.responsible = responsible;
    }

    public static String getProjectNameThai() {
        return projectNameThai;
    }

    public static void setProjectNameThai(String projectNameThai) {
        ProjectDetail.projectNameThai = projectNameThai;
    }

    public static String getProjectNameEnglish() {
        return projectNameEnglish;
    }

    public static void setProjectNameEnglish(String projectNameEnglish) {
        ProjectDetail.projectNameEnglish = projectNameEnglish;
    }

    public static String getDepartment() {
        return department;
    }

    public static void setDepartment(String department) {
        ProjectDetail.department = department;
    }

    public static String getAdvisors() {
        return Advisors;
    }

    public static void setAdvisors(String Advisors) {
        ProjectDetail.Advisors = Advisors;
    }

    public static String getRationale() {
        return rationale;
    }

    public static void setRationale(String rationale) {
        ProjectDetail.rationale = rationale;
    }

    public static int getPlaceType() {
        return placeType;
    }

    public static void setPlaceType(int placeType) {
        ProjectDetail.placeType = placeType;
    }

    public static String getPlaceLocation() {
        return placeLocation;
    }

    public static void setPlaceLocation(String placeLocation) {
        ProjectDetail.placeLocation = placeLocation;
    }

    public static int getNumOfStudent() {
        return numOfStudent;
    }

    public static void setNumOfStudent(int numOfStudent) {
        ProjectDetail.numOfStudent = numOfStudent;
    }

    public static int getNumCome() {
        return numCome;
    }

    public static void setNumCome(int numCome) {
        ProjectDetail.numCome = numCome;
    }

    public static String getObjective() {
        return objective;
    }

    public static void setObjective(String objective) {
        ProjectDetail.objective = objective;
    }

    public static String getExpected() {
        return expected;
    }

    public static void setExpected(String expected) {
        ProjectDetail.expected = expected;
    }

    public static double getBudget() {
        return budget;
    }

    public static void setBudget(double budget) {
        ProjectDetail.budget = budget;
    }

    public static double getCost() {
        return cost;
    }

    public static void setCost(double cost) {
        ProjectDetail.cost = cost;
    }

    public static Date getOpenTime() {
        return openTime;
    }

    public static void setOpenTime(Date openTime) {
        ProjectDetail.openTime = openTime;
    }

    public static Date getStartTime() {
        return startTime;
    }

    public static void setStartTime(Date startTime) {
        ProjectDetail.startTime = startTime;
    }

    public static Date getEndTime() {
        return endTime;
    }

    public static void setEndTime(Date endTime) {
        ProjectDetail.endTime = endTime;
    }

    public static Date getCloseTime() {
        return closeTime;
    }

    public static void setCloseTime(Date closeTime) {
        ProjectDetail.closeTime = closeTime;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        ProjectDetail.status = status;
    }

    public static Committee[] getCommittee() {
        return committee;
    }

    public static void setCommittee(Committee[] committee) {
        ProjectDetail.committee = committee;
    }

    public static Comment[] getComment() {
        return comment;
    }

    public static void setComment(Comment[] comment) {
        ProjectDetail.comment = comment;
    }

    public static ProjectProcess[] getProcess() {
        return process;
    }

    public static void setProcess(ProjectProcess[] process) {
        ProjectDetail.process = process;
    }

    public static Money[] getMoney() {
        return money;
    }

    public static void setMoney(Money[] money) {
        ProjectDetail.money = money;
    }

    
}
