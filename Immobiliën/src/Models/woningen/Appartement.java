package Models.woningen;

import Models.*;
import Models.factory.KamerFactory;
import Models.kamers.*;
import com.sun.jndi.ldap.Ber;

import java.util.ArrayList;
import java.util.Random;

public class Appartement extends Woning {
    /* Appartement bestaat uit maximaal 1 woonkamers, 1 keuken, 1 badkamer, 1 berging, 1 balkon, 1 garage en minmaal 1 slaapkamers, */
    private final int aantalWoonkamers = 1;
    private final int aantalKeukens = 1;
    private int aantalSlaapkamers = 1;
    private final int aantalBadkamers = 1;
    private int aantalBerging = 0;
    private int aantalBalkon = 0;
    private int aantalGarages = 0;
    private final int aantalTuin = 0;
    private Random random = new Random();

    public Appartement(){
        ArrayList<Kamer> kamers = new ArrayList<Kamer>();
        /* Aanmaak van de woonkamers */
        kamers.add(KamerFactory.createKamer(KamerEnum.Woonkamer.getKamer(), 20,30));

        /* Aanmaak van de keuken */
        kamers.add(KamerFactory.createKamer(KamerEnum.Keuken.getKamer(), 15,20));

        /* Aanmaak van de slaapkamers */
        aantalSlaapkamers += random.nextInt(3);
        for(int x = 0; x < aantalSlaapkamers; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Slaapkamer.getKamer(), 20,40));
        }

        /* Aanmaak van de badkamer */
        kamers.add(KamerFactory.createKamer(KamerEnum.Badkamer.getKamer(), 15,15));

        /* Aanmaak van de berging */
        aantalBerging += random.nextInt(2);
        for(int x = 0; x < aantalBerging; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Berging.getKamer(), 5,10));
        }

        /* Aanmaak van de balkon */
        aantalBalkon += random.nextInt(2);
        for(int x = 0; x < aantalBalkon; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Balkon.getKamer(), 20,40));
        }

        /* Aanmaak van de garage */
        aantalGarages += random.nextInt(2);
        for(int x = 0; x < aantalGarages; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Garage.getKamer(), 25,20));
        }

        setKamers(kamers);
        setPrijsWonging(this.calPrijsWoning());
    }

    public Object[][] getOutput() {
        Object[][] output = {
                {"Appartement", "Woonkamer", aantalWoonkamers},
                {" ", "Slaapkamer", aantalSlaapkamers},
                {" ", "Keuken", aantalKeukens},
                {" ", "Badkamers", aantalBadkamers},
                {" ", "Berging", aantalBerging},
                {" ", "Garage", aantalGarages},
                {" ", "Balkon", aantalBalkon},
                {" ", " ", " "},
                {"", "Prijs: ", String.format("%-5s", String.format("%1.2f", getPrijsWonging()))},
                {" ", " ", " "},
        };
        return output;
    }

    public double calPrijsWoning() {
        ArrayList<Kamer> kamers = getKamers();
        double output = EenheidsprijsEnum.Appartement.getPrijs();
        int oppervlakte = 0;
        double bijkomendePrijs = 1.00;

        for (Kamer k: kamers) {
            oppervlakte += k.getOppervlakte();
            if(k instanceof Garage){
                bijkomendePrijs += 0.05;
            }
            if(k instanceof Balkon){
                bijkomendePrijs += 0.025;
            }
        }
        output = (output * oppervlakte) * bijkomendePrijs;

        return output;
    }

    @Override
    public String toString() {
        return "Appartement";
    }
}
