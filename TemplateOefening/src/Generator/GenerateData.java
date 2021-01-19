package Generator;

import Factory.PersonenFactory;
import Factory.VacinFactory;
import Generator.Dummy.DummyPersonen;
import Models.Persoon;
import Models.Vacin;

import java.util.ArrayList;
import java.util.Random;

import static Factory.PersonenFactory.createPersoon;

public class GenerateData {


    public static ArrayList<Vacin> GenerateData(){
        ArrayList<Persoon> personen = new ArrayList<Persoon>();
        ArrayList<Vacin> vacins = new ArrayList<Vacin>();
        Random random;

        /*for (int x = 0; x < 8; x++){
            Persoon persoon;
            persoon = PersonenFactory.createPersoon(DummyPersonen.getVoornaam(), DummyPersonen.getAchternaam(), DummyPersonen.getGeboortedatum());
            personen.add(persoon);
        }*/

        while(personen.size() < 8){
            Persoon persoon;
            persoon = PersonenFactory.createPersoon(DummyPersonen.getVoornaam(), DummyPersonen.getAchternaam(), DummyPersonen.getGeboortedatum());
            if(!personen.contains(persoon)){
                personen.add(persoon);
            }
        }

        int temp = 0;
        for(int x = 0; x < 4; x++){
            for(int y = temp; y < temp + 2; y++){
                Vacin vacin;
                vacin = VacinFactory.createVacin(x, personen.get(y));
                vacins.add(vacin);
            }
            temp += 2;
        }

        return vacins;
    }
}
