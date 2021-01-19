package UI;

import Models.Vacin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class LoggerVaccin {

    public static void log(ArrayList<Vacin> vacinArrayList){
        ArrayList<Vacin> vacins = vacinArrayList;

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("MyLog");
        FileHandler fh;

        File targetFile = new File("C:/test/VacinLog.logs");
        File parent = targetFile.getParentFile();
        parent.mkdir();

        try {
            fh = new FileHandler("C:/test/VacinLog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.setUseParentHandlers(false);

            int teller = 1;
            for (Vacin vacin: vacins) {
                logger.info("Vaccinatie " + teller +  ": " + vacin.toString());
                teller++;
            }

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
