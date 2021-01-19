package demoSuper;

public abstract class Coworker extends Person{
    private String idCard;
    private String locker;

    public Coworker(String name, String firstName, String idCard, String locker) {
        super(name, firstName);
        this.idCard = idCard;
        this.locker = locker;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLocker() {
        return locker;
    }

    public void setLocker(String locker) {
        this.locker = locker;
    }

    @Override
    public String toString() {
        return "Coworker{" +super.toString() +
                "\n \t idCard='" + idCard + '\'' +
                ", locker='" + locker + '\'' +
                '}';
    }
}
