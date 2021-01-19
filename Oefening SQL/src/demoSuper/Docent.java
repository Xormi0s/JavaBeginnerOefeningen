package demoSuper;

public class Docent extends Coworker{
    private String agenda;

    public Docent(String name, String firstName, String idCard, String locker, String agenda) {
        super(name, firstName, idCard, locker);
        this.agenda = agenda;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return "Docent{" + super.toString() +
                "\n \t  agenda='" + agenda + '\'' +
                '}';
    }
}
