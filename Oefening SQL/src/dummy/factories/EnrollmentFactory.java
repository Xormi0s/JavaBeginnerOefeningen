package dummy.factories;

import model.Enrollment;
import model.Course;
import model.Student;

import java.sql.Date;
import java.time.LocalDate;

public class EnrollmentFactory {
    public static Enrollment createEnrollment(Student student, Course course, LocalDate date, String grade) {
        return new Enrollment(student.getSsn(),course.getCourseID(),date ,grade);
    }
}
