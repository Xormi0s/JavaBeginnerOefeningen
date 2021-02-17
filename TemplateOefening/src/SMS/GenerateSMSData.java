package SMS;

import Generator.GenerateData;
import Models.Covid19;
import Models.Vacin;

import java.util.ArrayList;
import java.util.Random;

public class GenerateSMSData {

    public static ArrayList<Subject> generateData(){
        Random random = new Random();
        ArrayList<Subject> output = new ArrayList<Subject>();

        // Gebruik van 3 arraylists om iets meer test data te voorzien. Generator maakte per vaccin 2 personen aan maar en dit is te weinig testdata.
        // Niet optimaal maar zo moet de oude code niet aangepast worden zoals gevraagd.
        ArrayList<Vacin> vacinsTest1 = GenerateData.GenerateData();
        ArrayList<Vacin> vacinsTest2 = GenerateData.GenerateData();
        ArrayList<Vacin> vacinsTest3 = GenerateData.GenerateData();

        Subject subject1 = SubjectFactory.createSubject(random.nextInt(4));
        Subject subject2 = SubjectFactory.createSubject(random.nextInt(4));
        Subject subject3 = SubjectFactory.createSubject(random.nextInt(4));

        for (Vacin vacin: vacinsTest1){
            if(vacin instanceof Covid19){
                subject1.add(vacin.persoon);
            }
        }

        for (Vacin vacin: vacinsTest2){
            if(vacin instanceof Covid19){
                subject2.add(vacin.persoon);
            }
        }

        for (Vacin vacin: vacinsTest3){
            if(vacin instanceof Covid19){
                subject3.add(vacin.persoon);
            }
        }

        output.add(subject1);
        output.add(subject2);
        output.add(subject3);
        return  output;
    }
}
