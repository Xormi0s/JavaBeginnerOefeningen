package Models.woningen;

import Models.*;
import Models.factory.KamerFactory;
import Models.kamers.*;

import javax.naming.RefAddr;
import java.util.ArrayList;
import java.util.Random;

public class Huis  extends Woning {
    /* Huis bestaat uit maximaal 1 woonkamers, 1 keuken, 1 badkamer, 1 tuin, 1 garage en minimaal 2 slaapkamers */
    private final int aantalWoonkamers = 1;
    private final int aantalKeukens = 1;
    private int aantalSlaapkamers = 2;
    private final int aantalBadkamers = 1;
    private int aantalGarages = 0;
    private final int aantalTuin = 1;
    private Random random = new Random();


    public Huis(){
        ArrayList<Kamer> kamers = new ArrayList<Kamer>();
        /* Aanmaak van de woonkamer */
        kamers.add(KamerFactory.createKamer(KamerEnum.Woonkamer.getKamer(), 35,55));

        /* Aanmaak van de keuken */
        kamers.add(KamerFactory.createKamer(KamerEnum.Keuken.getKamer(), 25,25));

        /* Aanmaak van de slaapkamers */
        aantalSlaapkamers += random.nextInt(3);
        for(int x = 0; x < aantalSlaapkamers; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Slaapkamer.getKamer(), 15,40));
        }

        /* Aanmaak van de badkamer */
        kamers.add(KamerFactory.createKamer(KamerEnum.Badkamer.getKamer(), 15,25));

        /* Aanmaak van de garage */
        aantalGarages += random.nextInt(2);
        for(int x = 0; x < aantalGarages; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Garage.getKamer(), 30,70));
        }

        /* Aanmaak van de tuin */
        kamers.add(KamerFactory.createKamer(KamerEnum.Tuin.getKamer(), 20,120));

        setKamers(kamers);
        setPrijsWonging(this.calPrijsWoning());
    }

    public Object[][] getOutput() {
        Object[][] output = {
                {"Huis", "Woonkamer", aantalWoonkamers},
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
        double output = EenheidsprijsEnum.Huis.getPrijs();
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
        return "Huis";
    }
}
