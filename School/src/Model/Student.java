package Model;

import javax.print.DocFlavor;
import java.time.LocalDate;

public class Student {
    private String ssn;
    private String firstName;
    private String mi;
    private String lastName;
    private LocalDate birthDate;
    private String phone;
    private String zipCode;
    private String deptId;

    public Student(String ssn, String firstName, String mi, String lastName, LocalDate birthDate, String phone, String zipCode, String deptId) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.mi = mi;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.zipCode = zipCode;
        this.deptId = deptId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", mi=" + mi +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", deptId='" + deptId + '\'' +
                '}';
    }
}
