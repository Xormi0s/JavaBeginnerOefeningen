package dummy.test;

import dummy.DummyCourse;
import dummy.RandomGenerator;
import dummy.factories.CourseFactory;
import dummy.factories.StudentFactory;
import model.Course;
import model.Enrollment;
import model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persistance.DatabaseEnumeration;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class testPersistentEnrollment {

    String courseID, ssn;
    ResultSet rs;
    DatabaseEnumeration database;
    Student student;
    Course course;
    Connection connection;
    Statement statement;
    private Enrollment testEnrollment;

    @Before
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        DatabaseSelection.setCurrentDatabase(DatabaseEnumeration.PROPERTIES);
        courseID = "11111";
        ssn = "SSN001";
        connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        statement = connection.createStatement();
         rs = statement.executeQuery("Select * from enrollment");
    }

    @Test
    public void testCreateEnrollment() throws SQLException, ClassNotFoundException, IOException  {
        course = CourseFactory.createDummyCourse(RandomGenerator.random.nextInt(DummyCourse.MAX_COURSES));
        student = StudentFactory.createRandomStudent();
        PersistentCourse.persistCourse(course);
        PersistentStudent.persistStudent(student);

        PersistentEnrollment.persistEnrollment(student,course,LocalDate.now(),"A");
    }

    @Test
    public void testGetEnrollment() throws SQLException, ClassNotFoundException, IOException  {

        testEnrollment = PersistentEnrollment.getEnrollment(ssn, courseID);
        System.out.println(testEnrollment);
    }

    @Test
    public void testGetAllenrollments()
            throws SQLException, ClassNotFoundException, IOException  {
        while (rs.next()) {
            Enrollment enrollment = PersistentEnrollment.getEnrollment(rs);
            System.out.println(enrollment);
        }
    }

    @Test
    public void testCleanUpEnrollments() throws SQLException, ClassNotFoundException, IOException  {
        PersistentEnrollment.cleanUp();
        PersistentStudent.cleanUp();
        PersistentCourse.cleanUp();
    }
}
