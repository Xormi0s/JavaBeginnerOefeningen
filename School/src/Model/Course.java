package Model;

public class Course {
    private String courseId;
    private String subjectId;
    private int courseNumber;
    private String title;
    private int numOfCredits;

    public Course(String courseId, String subjectId, int courseNumber, String title, int numOfCredits) {
        this.courseId = courseId;
        this.subjectId = subjectId;
        this.courseNumber = courseNumber;
        this.title = title;
        this.numOfCredits = numOfCredits;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumOfCredits() {
        return numOfCredits;
    }

    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", subjectId='" + subjectId + '\'' +
                ", courseNumber=" + courseNumber +
                ", title='" + title + '\'' +
                ", numOfCredits=" + numOfCredits +
                '}';
    }
}
