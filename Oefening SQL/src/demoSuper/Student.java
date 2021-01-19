package demoSuper;

public class Student extends Person{
    private String idCard;

    public Student(String name, String firstName, String idCard) {
        super(name, firstName);
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Student{" +super.toString() +
                "\n \t idCard='" + idCard + '\'' +
                '}';
    }
}
