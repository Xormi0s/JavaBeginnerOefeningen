package SMS;

import java.util.ArrayList;

public class Subject {
    private String message;
    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public Subject(String message) {
        this.message = message;
    }

    public void add(Observer observer){
        observers.add(observer);
    }

    public void remove(Observer observer){
        observers.remove(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
