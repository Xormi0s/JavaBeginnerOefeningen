package dummy.test;

import dummy.DummyCourse;
import dummy.factories.CourseFactory;
import model.Course;
import persistance.DatabaseEnumeration;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class PersistentCourse {
    private static int sequence = 1;
    public static void initialLoad()
            throws SQLException, ClassNotFoundException, IOException {
// Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        // Create a statement
        PreparedStatement preparedStatement = connection.prepareStatement("insert into course Values(?,?,?,?,?)");
        // Execute a statement
        for (int i = 0; i < DummyCourse.MAX_COURSES; i++) {
            Course course = CourseFactory.createDummyCourse(i);
            preparedStatement.setString(1, course.getCourseID());
            preparedStatement.setString(2, course.getSubjectID());
            preparedStatement.setInt(3, course.getCourseNumber());
            preparedStatement.setString(4, course.getTitle());
            preparedStatement.setInt(5, course.getNumOfCredits());
            preparedStatement.execute();
        }

        // Close the connection
        connection.close();
    }

    public static Course getCourse(DatabaseEnumeration database, String courseID) throws SQLException, ClassNotFoundException, IOException  {

        // Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());

        PreparedStatement statement = connection.prepareStatement("Select * from Course where courseID = ?");
        statement.setString(1, courseID);
        Course course = null;
        try (ResultSet set = statement.executeQuery()) {
            if(set.next()) {
                course = new Course(set.getString(1),
                        set.getString(2),
                        set.getInt(3),
                        set.getString(4),
                        set.getInt(5));
            }
        }
        return course;
    }

    public static Course getCourse(ResultSet rs) throws SQLException {
        return new Course(rs.getString(1),
                rs.getString(2),
                rs.getInt(3),
                rs.getString(4),
                rs.getInt(5));
    }


    public static void persistCourse(Course course) throws SQLException, ClassNotFoundException, IOException  {
        // Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        // Create a statement

        PreparedStatement preparedStatement = connection.prepareStatement("insert into Course Values(?,?,?,?,?)");
        // Execute a statement
        preparedStatement.setString(1, course.getCourseID());
        preparedStatement.setString(2, course.getSubjectID());
        preparedStatement.setInt(3, course.getCourseNumber());
        preparedStatement.setString(4, course.getTitle());
        preparedStatement.setInt(5, course.getNumOfCredits());
        preparedStatement.execute();
    }


    public static void cleanUp() throws SQLException, ClassNotFoundException, IOException  {
        // Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from Course");
    }

    public static int getLastCourseID(Connection connection) throws SQLException {
        Optional<String> opt;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select max(courseID) from Course");
        String courseID;
        int temp = 0;
        if (rs.next()){
            opt =  Optional.ofNullable(rs.getString(1));
            courseID = opt.orElse("11111");
            temp = Integer.parseInt(courseID.trim());
            //temp ++;
        }
        return temp;
    }
}