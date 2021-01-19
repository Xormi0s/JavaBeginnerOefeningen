package Model;

import java.time.LocalDate;

public class Enrollment {
    private String ssn;
    private String courseId;
    private LocalDate dateRegistered;
    private String grade;

    public Enrollment(String ssn, String courseId, LocalDate dateRegistered, String grade) {
        this.ssn = ssn;
        this.courseId = courseId;
        this.dateRegistered = dateRegistered;
        this.grade = grade;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(LocalDate dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "ssn='" + ssn + '\'' +
                ", courseId='" + courseId + '\'' +
                ", dateRegistered=" + dateRegistered +
                ", grade='" + grade + '\'' +
                '}';
    }
}
