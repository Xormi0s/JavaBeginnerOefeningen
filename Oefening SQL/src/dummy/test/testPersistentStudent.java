package dummy.test;

import dummy.factories.StudentFactory;
import model.Student;
import org.junit.Before;
import org.junit.Test;
import persistance.DatabaseEnumeration;
import persistance.DatabaseSelection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testPersistentStudent {

    private Student testStudent, newStudent;
    private String ssn;
    ResultSet rs;

    @Before
    public void setUp() throws SQLException, ClassNotFoundException, IOException {
        DatabaseSelection.setCurrentDatabase(DatabaseEnumeration.PROPERTIES);
        ssn = StudentFactory.getSsnNumber(0, 0, 1);
        Connection connection = DatabaseSelection.getDatabase(DatabaseSelection.getCurrentDatabase());
        Statement statement = connection.createStatement();
        rs = statement.executeQuery("Select * from Student");
        newStudent = StudentFactory.createStudent(PersistentStudent.getLastSSN(connection));
    }

    @Test
    public void testGetStudent() throws SQLException, ClassNotFoundException, IOException  {

        testStudent = PersistentStudent.getStudent(ssn.toUpperCase());
        System.out.println(testStudent);
    }
    @Test
    public void testGetAllStudents()
            throws SQLException, ClassNotFoundException, IOException  {
        while(rs.next()){
            Student student = StudentFactory.createRandomStudent(rs);
            System.out.println(student);
        }
    }

    @Test
    public void testCreateStudent()throws SQLException, ClassNotFoundException, IOException  {
        PersistentStudent.persistStudent(newStudent);
    }



    @Test
    public void testCleanUpStudents()throws SQLException, ClassNotFoundException, IOException {
        PersistentStudent.cleanUp();
    }
}
