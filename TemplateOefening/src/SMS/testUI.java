package SMS;

import java.util.ArrayList;

public class testUI {

    public static void main(String[] args) {
        ArrayList<Subject> subjects = GenerateSMSData.generateData();

        for (Subject subject: subjects){
            subject.notifyAllObservers();
        }
    }
}
