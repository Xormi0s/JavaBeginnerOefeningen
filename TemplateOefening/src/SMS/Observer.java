package SMS;

public abstract class Observer {

    private Subject subject;
    public abstract void update(String message);
}
