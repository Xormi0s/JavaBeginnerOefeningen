package Models.woningen;

import Models.*;
import Models.factory.KamerFactory;
import Models.kamers.*;

import java.util.ArrayList;
import java.util.Random;

public class Villa extends Woning {
    /* Villa bestaat uit minstens 1 woonkamers, 1 keuken, 1 badkamer, 4 slaapkamers, 1 garage en maximaal 1 tuin */
    private int aantalWoonkamers = 1;
    private int aantalKeukens = 1;
    private int aantalSlaapkamers = 4;
    private int aantalBadkamers = 1;
    private int aantalGarages = 1;
    private final int aantalTuin = 1;
    private Random random = new Random();

    public Villa(){
        ArrayList<Kamer> kamers = new ArrayList<Kamer>();

        /* Aanmaak van de woonkamers */
        aantalWoonkamers += random.nextInt(2);
        for(int x = 0; x < aantalWoonkamers; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Woonkamer.getKamer(),50,100));
        }

        /* Aanmaak van de keukens */
        aantalKeukens += random.nextInt(2);
        for(int x = 0; x < aantalKeukens; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Keuken.getKamer(), 30,50));
        }

        /* Aanmaak van de slaapkamers */
        aantalSlaapkamers += random.nextInt(3);
        for(int x = 0; x < aantalSlaapkamers; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Slaapkamer.getKamer(), 20,40));
        }

        /* Aanmaak van de badkamers */
        aantalBadkamers += random.nextInt(2);
        for(int x = 0; x < aantalBadkamers; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Badkamer.getKamer(), 20,40));
        }

        /* Aanmaak van de garages */
        aantalGarages += random.nextInt(2);
        for(int x = 0; x < aantalGarages; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Garage.getKamer(), 30,120));
        }

        /* Aanmaak van de tuin */
        kamers.add(KamerFactory.createKamer(KamerEnum.Tuin.getKamer(), 80,120));

        setKamers(kamers);
        setPrijsWonging(this.calPrijsWoning());
    }

    public Object[][] getOutput() {
        Object[][] output = {
                {"Villa", "Woonkamer", aantalWoonkamers},
                {" ", "Slaapkamer", aantalSlaapkamers},
                {" ", "Keuken", aantalKeukens},
                {" ", "Badkamer", aantalBadkamers},
                {" ", "Garage", aantalGarages},
                {" ", "Tuin", aantalTuin},
                {" ", " ", " "},
                {"", "Prijs: ", String.format("%-5s", String.format("%1.2f", getPrijsWonging()))},
                {" ", " ", " "},
        };
        return output;
    }

    public double calPrijsWoning() {
        ArrayList<Kamer> kamers = getKamers();
        double output = EenheidsprijsEnum.Villa.getPrijs();
        int oppervlakte = 0;
        double bijkomendePrijs = 1.00;

        for (Kamer k: kamers) {
            oppervlakte += k.getOppervlakte();
            if(k instanceof Tuin){
                bijkomendePrijs += 0.10;
            }
            if(k instanceof Garage){
                bijkomendePrijs += 0.05;
            }
        }
        output = (output * oppervlakte) * bijkomendePrijs;

        return output;
    }

    @Override
    public String toString() {
        return "Villa";
    }
}
