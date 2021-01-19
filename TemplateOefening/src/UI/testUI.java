package UI;

import Generator.GenerateData;
import Models.Vacin;

import java.util.ArrayList;


public class testUI {

    public static void main(String[] args) {
        ArrayList<Vacin> vacins = GenerateData.GenerateData();

        for(int x= 0; x < vacins.size(); x++){
            System.out.print("Vaccinatie " + (x + 1) + ": " + vacins.get(x) + "\n");
        }

        LoggerVaccin.log(vacins);
    }
}
