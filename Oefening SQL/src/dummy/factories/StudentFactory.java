package dummy.factories;

import model.Student;
import dummy.DummyStudent;
import dummy.RandomGenerator;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentFactory {
    private static int ssnFirstNumber = 0;
    private static int ssnMiddleNumber = 0;
    private static int ssnLastNumber = 0;
    private static String ssn;
    private static String firstName;
    private static String lastName;
    private static String street;
    private static String zip;
    private static String mi;
    private static String dept;
    private static String phone;
    private static LocalDate birtDate;

    public static Student createRandomStudent() {
        generateDummyData();
        return new Student(ssn, firstName, mi, lastName, birtDate, street, phone, zip, dept);
    }

    public static Student createStudent(int ssnNumber){
        generateDummyData();
        calculateSSNNumber(ssnNumber);
        String ssn = "SSN"+getSsnNumber();
        return new Student (ssn, firstName, mi, lastName, birtDate, street, phone, zip, dept);
    }
    public static Student createRandomStudent(ResultSet rs) throws SQLException {
         ssn = rs.getString(1);
         firstName = rs.getString(2);
         mi = rs.getString(3);
         lastName = rs.getString(4);
        Date birtDate = rs.getDate(5);
         street = rs.getString(6);
         zip = rs.getString(7);
         phone = rs.getString(8);
         dept = rs.getString(9);

        return new Student(ssn, firstName, mi, lastName, birtDate.toLocalDate(), street, phone, zip, dept);
    }
    private static String getSsnNumber() {
        //SSNxxx
        if (ssnLastNumber < 9) {
            ssnLastNumber++;
        } else {
            ssnLastNumber = 0;
            if (ssnMiddleNumber < 9) {
                ssnMiddleNumber++;
            } else {
                ssnMiddleNumber = 0;
                if (ssnFirstNumber < 9) {
                    ssnFirstNumber++;
                } else {
                    ssnFirstNumber = 0;
                }
            }

        }
        return String.valueOf(ssnFirstNumber) + ssnMiddleNumber + ssnLastNumber;
    }

    public static String getSsnNumber(int first, int middle, int last) {

        return new StringBuilder().append("SSN").append(String.valueOf(first)).append(String.valueOf(middle)).append(String.valueOf(last)).toString();
    }

    private static void generateDummyData(){
        ssn = "SSN" + getSsnNumber();
        firstName = DummyStudent.firstName[RandomGenerator.random.nextInt(DummyStudent.firstName.length)];
        lastName = DummyStudent.lastName[RandomGenerator.random.nextInt(DummyStudent.lastName.length)];
        street = DummyStudent.street[RandomGenerator.random.nextInt(DummyStudent.street.length)];
        zip = String.valueOf(1000 + RandomGenerator.random.nextInt(9000));
        mi = DummyStudent.mi[RandomGenerator.random.nextInt(DummyStudent.mi.length)];
        dept = DummyStudent.department[RandomGenerator.random.nextInt(DummyStudent.department.length)];
        int year = 1980 + RandomGenerator.random.nextInt(30);
        int month = 1 + RandomGenerator.random.nextInt(12);
        int day = 1 + RandomGenerator.random.nextInt(28);
        birtDate = LocalDate.of(year, month, day);
        // System.out.println(new StringBuilder().append(birtDate.toString()).append(" ").append(birtDate.toEpochDay()).toString());
         phone = String.valueOf(RandomGenerator.random.nextInt(99_999_999));
    }

    private static void calculateSSNNumber(int ssnNumber){
        int temp = ssnNumber;
        ssnFirstNumber = ssnNumber  / 100;
        if (ssnFirstNumber > 0) {
            temp -= (ssnFirstNumber * 100);
        }
        ssnMiddleNumber = temp / 10;
        if (ssnMiddleNumber > 0){
            temp -= (ssnMiddleNumber *10);
        }
        ssnLastNumber = temp;
    }
}
