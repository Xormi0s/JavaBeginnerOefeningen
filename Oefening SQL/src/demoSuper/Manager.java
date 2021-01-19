package demoSuper;

public class Manager extends Coworker{
    private String companyCar;

    public Manager(String name, String firstName, String idCard, String locker, String companyCar) {
        super(name, firstName, idCard, locker);
        this.companyCar = companyCar;
    }

    public String getCompanyCar() {
        return companyCar;
    }

    public void setCompanyCar(String companyCar) {
        this.companyCar = companyCar;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "\n \t  companyCar='" + companyCar + '\'' +
                '}';
    }
}
