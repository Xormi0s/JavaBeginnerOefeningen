package dummy.test;

import dummy.DummyStudent;
import dummy.factories.StudentFactory;
import model.Student;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class PersistentStudent {

    public static void initialLoad()
            throws SQLException, ClassNotFoundException, IOException {

        // Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());

        // Create a statement

        PreparedStatement preparedStatement = connection.prepareStatement("insert into student Values(?,?,?,?,?,?,?,?,?)");
        // Execute a statement
        for (int i = 0; i < DummyStudent.MAX_STUDENTS; i++) {
            Student student = StudentFactory.createRandomStudent();
            preparedStatement.setString(1, student.getSsn());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getMi());
            preparedStatement.setString(4, student.getLastName());
            preparedStatement.setObject(5, Date.valueOf(student.getBirthDate()));
            preparedStatement.setString(6, student.getStreet());
            preparedStatement.setString(7, student.getPhone());
            preparedStatement.setString(8, student.getZipCode());
            preparedStatement.setString(9, student.getDeptID());
            preparedStatement.execute();
        }

        // Close the connection
        connection.close();
    }
    public static void persistStudent(Student student)throws SQLException, ClassNotFoundException, IOException  {

        // Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());

        // Create a statement

        PreparedStatement preparedStatement = connection.prepareStatement("insert into student Values(?,?,?,?,?,?,?,?,?)");
        // Execute a statement
        preparedStatement.setString(1, student.getSsn());
        preparedStatement.setString(2, student.getFirstName());
        preparedStatement.setString(3, student.getMi());
        preparedStatement.setString(4, student.getLastName());
        preparedStatement.setDate(5, Date.valueOf(student.getBirthDate()));
        preparedStatement.setString(6, student.getStreet());
        preparedStatement.setString(7, student.getPhone());
        preparedStatement.setString(8, student.getZipCode());
        preparedStatement.setString(9, student.getDeptID());
        preparedStatement.execute();
    }

    public static Student getStudent(String ssn) throws SQLException, ClassNotFoundException, IOException  {
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        String sqlString = "Select * from Student where ssn = ?";
        PreparedStatement statement = connection.prepareStatement(sqlString);
        statement.setString(1, ssn);
        Student student = null;
        try  {
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                ResultSetMetaData md = set.getMetaData();
                student = new Student(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getDate(5).toLocalDate(),
                        set.getString(6),
                        set.getString(7),
                        set.getString(8),
                        set.getString(9));
            }
        } catch (SQLException sqlException) {
            System.out.println("SQL Exception "+sqlException.getSQLState());
            throw new SQLException(sqlException);
        }

        // Close the connection
        connection.close();

        return student;
    }

    public static Student getStudent(ResultSet rs) throws SQLException {
        Student student = new Student(rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getDate(5).toLocalDate(),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9));
        return student;
    }

    public static void cleanUp() throws SQLException, ClassNotFoundException, IOException {
        // Connect to a database
        Connection connection =DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        Statement statement = connection.createStatement();
        statement.executeUpdate("delete from Student");
    }

    public static int getLastSSN(Connection connection) throws SQLException {
        Optional<String> opt;
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select max(ssn) from Student");
        String lastSSN;
        int temp = 0;
        if (rs.next()){
            opt =  Optional.ofNullable(rs.getString(1));
            lastSSN = opt.orElse("SSN001");
            temp = Integer.parseInt(lastSSN.trim().substring(3));
            //temp ++;
        }
        return temp;
    }
}