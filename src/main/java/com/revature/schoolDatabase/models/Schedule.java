package com.revature.schoolDatabase.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {
    @JsonProperty("courseDept")
    private String courseDept;
    @JsonProperty("courseNo")
    private int courseNo;
    @JsonProperty("sectionNo")
    private int sectionNo;
    @JsonProperty("meetingTimes")
    private ArrayList<MeetingTime> meetingTimes = new ArrayList<>();

    // Constructors
    public Schedule() {

    }

    public Schedule (String courseDept, int courseNo, int sectionNo) {
        this.courseDept = courseDept;
        this.courseNo = courseNo;
        this.sectionNo = sectionNo;
        meetingTimes = null;
    }

    // Schedule is created with ID as one String
//    public Schedule(String courseDept, String courseID) {
////        String[] splitID = courseID.split("-");
//        this.courseDept = courseDept;
//        this.courseNo = Integer.parseInt(splitID[0]);
//        this.sectionNo = Integer.parseInt(splitID[1]);
//    }

    public Schedule(String courseDept, int courseNo, int sectionNo, ArrayList<MeetingTime> meetingTimes) {
        this(courseDept, courseNo, sectionNo);
        this.meetingTimes = meetingTimes;
    }

    // Getters and Setters
    public String getCourseDept() {
        return courseDept;
    }

    public void setCourseDept(String courseDept) {
        this.courseDept = courseDept;
    }

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public int getSectionNo() {
        return sectionNo;
    }

    public void setSectionNo(int sectionNo) {
        this.sectionNo = sectionNo;
    }

    public ArrayList<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    public void setMeetingTimes(ArrayList<MeetingTime> meetingTimes) {
        this.meetingTimes = meetingTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return courseNo == schedule.courseNo && sectionNo == schedule.sectionNo && courseDept.equals(schedule.courseDept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseDept, courseNo, sectionNo, meetingTimes);
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "courseDept='" + courseDept + '\'' +
                ", courseNo=" + courseNo +
                ", sectionNo=" + sectionNo +
                ", meetingTimes=" + meetingTimes +
                '}';
    }

    // Other Methods
    /**
     * Displays meeting times of Course if available
     */
    public void displayMeetingTimes() {
        if (meetingTimes.isEmpty())
            return;
        else {
            System.out.println("Meeting Times:");
            for (MeetingTime meetingTime : meetingTimes) {
                System.out.print("\t\t" + meetingTime.getDay());
                System.out.print(" " + meetingTime.getStartTime());
                System.out.print(" - " + meetingTime.getEndTime());
                System.out.println(" (" + meetingTime.getClassType() + ")");
            }
        }
    }
}
