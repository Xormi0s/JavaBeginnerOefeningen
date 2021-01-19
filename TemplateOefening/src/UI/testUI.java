package UI;

import Generator.GenerateData;
import Models.Covid19;
import Models.Persoon;
import Models.Vacin;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

public class testUI {

    public static void main(String[] args) {
        ArrayList<Vacin> vacins = GenerateData.GenerateData();

        for(int x= 0; x < vacins.size(); x++){
            System.out.print("Vaccinatie " + (x + 1) + ": " + vacins.get(x) + "\n");
        }

        LoggerVaccin.log(vacins);
    }
}
