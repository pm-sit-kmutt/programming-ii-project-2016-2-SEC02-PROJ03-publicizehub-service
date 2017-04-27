/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicizehub_service.Class;
import java.util.Date;
/**
 *
 * @author นัน
 */
public class ProjectDetail {
    private static int id;
    private static String responsible;
    private static String projectNameThai;
    private static String projectNameEnglish;
    private static String Advisors;
    private static String department;
    private static String rationale;
    private static int placeType;
    private static int people;
    private static String placeLocation;
    private static double budget;
    private static double cost;
    private static String openTime;
    private static String startTime;
    private static String endTime;
    private static String closeTime;
    private static int status;
    private static String[] objective;
    private static String[] expected;
    private static Committee[] committee;
    private static Participants participants;
    private static Comment[] comment;

    
    public ProjectDetail() {
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

    public static String getOpenTime() {
        return openTime;
    }

    public static void setOpenTime(String openTime) {
        ProjectDetail.openTime = openTime;
    }

    public static String getStartTime() {
        return startTime;
    }

    public static void setStartTime(String startTime) {
        ProjectDetail.startTime = startTime;
    }

    public static String getEndTime() {
        return endTime;
    }

    public static void setEndTime(String endTime) {
        ProjectDetail.endTime = endTime;
    }

    public static String getCloseTime() {
        return closeTime;
    }

    public static void setCloseTime(String closeTime) {
        ProjectDetail.closeTime = closeTime;
    }

  

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        ProjectDetail.status = status;
    }

    public static String[] getObjective() {
        return objective;
    }

    public static void setObjective(String[] objective) {
        ProjectDetail.objective = objective;
    }

    public static String[] getExpected() {
        return expected;
    }

    public static void setExpected(String[] expected) {
        ProjectDetail.expected = expected;
    }

    public static Committee[] getCommittee() {
        return committee;
    }

    public static void setCommittee(Committee[] committee) {
        ProjectDetail.committee = committee;
    }

    public static Participants getParticipants() {
        return participants;
    }

    public static void setParticipants(Participants participants) {
        ProjectDetail.participants = participants;
    }

    public static Comment[] getComment() {
        return comment;
    }

    public static void setComment(Comment[] comment) {
        ProjectDetail.comment = comment;
    }

    public static String getAdvisors() {
        return Advisors;
    }

    public static void setAdvisors(String Advisors) {
        ProjectDetail.Advisors = Advisors;
    }

    public static int getPeople() {
        return people;
    }

    public static void setPeople(int people) {
        ProjectDetail.people = people;
    }
    
    
    
}
