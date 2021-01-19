package dummy.test;

import dummy.factories.EnrollmentFactory;
import model.Course;
import model.Enrollment;
import model.Student;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class PersistentEnrollment {
    public static void initialLoad()
            throws SQLException, ClassNotFoundException, IOException {

        // Connect to a database
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());

        PreparedStatement preparedStatement = connection.prepareStatement("insert into Enrollment Values(?,?,?,?)");
        Statement studentStmt = connection.createStatement();
        Statement courseStmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // Execute a statement
        ResultSet studentRS = studentStmt.executeQuery("Select * from Student");
        ResultSet courseRS = courseStmt.executeQuery("select * from course");
        while (studentRS.next()) {
            Student student = PersistentStudent.getStudent(studentRS);
            courseRS.first();
            while (courseRS.next()) {
                Course course = PersistentCourse.getCourse(courseRS);
                Enrollment Enrollment = EnrollmentFactory.createEnrollment(student, course, LocalDate.now(), "");
                preparedStatement.setString(1, Enrollment.getSsn());
                preparedStatement.setString(2, Enrollment.getCourseID());
                preparedStatement.setDate(3, Date.valueOf(Enrollment.getDateRegistered()));
                preparedStatement.setString(4, Enrollment.getGrade());
                preparedStatement.execute();
            }
        }
        studentRS.close();
        courseRS.close();
        connection.close();
    }

    public static void persistEnrollment(Student student, Course course, LocalDate date, String grade)
            throws SQLException, ClassNotFoundException, IOException {
        // Connect to a database
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());

        // Create a statement

        PreparedStatement preparedStatement = connection.prepareStatement("insert into Enrollment Values(?,?,?,?)");
        // Execute a statement
        preparedStatement.setString(1, student.getSsn());
        preparedStatement.setString(2, course.getCourseID());
        preparedStatement.setDate(3, Date.valueOf(date));
        preparedStatement.setString(4, grade);
        preparedStatement.execute();
    }

    public static void cleanUp() throws SQLException, ClassNotFoundException, IOException {
        // Connect to a database
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from Enrollment");
    }

    public static Enrollment getEnrollment(String ssn, String courseID) throws SQLException, ClassNotFoundException, IOException {
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        String sqlString = "Select * from Enrollment where ssn = ? and courseID = ?";
        PreparedStatement statement = connection.prepareStatement(sqlString);
        statement.setString(1, ssn);
        statement.setString(2, courseID);
        Enrollment enrollment = null;
        try (
                ResultSet set = statement.executeQuery()) {
            if (set.next()) {
                ResultSetMetaData md = set.getMetaData();
                enrollment = new Enrollment(set.getString(1),
                        set.getString(2),
                        set.getDate(3).toLocalDate(),
                        set.getString(4));
            }
        }
        // Close the connection
        connection.close();
        return enrollment;
    }

    public static Enrollment getEnrollment(ResultSet set) throws SQLException, ClassNotFoundException {

        ResultSetMetaData md = set.getMetaData();

            return new Enrollment(set.getString(1),
                    set.getString(2),
                    set.getDate(3).toLocalDate(),
                    set.getString(4));

    }
}