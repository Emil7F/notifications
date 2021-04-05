package pl.emil7f.notifications.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class NotificationInfoDto {

    private List<String> emails;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime courseStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime courseEndDate;

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public LocalDateTime getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(LocalDateTime courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public LocalDateTime getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(LocalDateTime courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    @Override
    public String toString() {
        return "NotificationInfoDto{" +
                "emails=" + emails +
                ", courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", courseStartDate=" + courseStartDate +
                ", courseEndDate=" + courseEndDate +
                '}';
    }
}

