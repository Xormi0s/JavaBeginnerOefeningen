package dummy.test;


import dummy.DummyCourse;
import dummy.RandomGenerator;
import dummy.factories.CourseFactory;
import model.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import persistance.DatabaseEnumeration;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testPersistentCourse {

    static int sequence = 1;
    String courseID;
    ResultSet rs;
    private Course testCourse, newCourse;

    @Before
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        DatabaseSelection.setCurrentDatabase(DatabaseEnumeration.PROPERTIES);
        courseID = CourseFactory.getCourseId(11111);
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        Statement statement = connection.createStatement();
        rs = statement.executeQuery("Select * from Course");
        newCourse = CourseFactory.createCourse(RandomGenerator.random.nextInt(DummyCourse.MAX_COURSES), PersistentCourse.getLastCourseID(connection));
    }

    @Test
    public void testCreateCourse() throws SQLException, ClassNotFoundException, IOException  {
        PersistentCourse.persistCourse(newCourse);
    }

    @Test
    public void testGetCourse() throws SQLException, ClassNotFoundException , IOException {

        testCourse = PersistentCourse.getCourse(DatabaseSelection.getCurrentDatabase(), courseID);
        System.out.println(testCourse);

    }

    @Test
    public void testGetAllCourses()
            throws SQLException, ClassNotFoundException , IOException {
        while (rs.next()) {
            Course course = PersistentCourse.getCourse(rs);
            System.out.println(course);

        }
    }

    @Test
    public void testCleanUpCourses() throws SQLException, ClassNotFoundException, IOException  {

        PersistentCourse.cleanUp();

    }
}
