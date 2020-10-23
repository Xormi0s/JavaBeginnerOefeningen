package Models.woningen;

import Models.EenheidsprijsEnum;
import Models.KamerEnum;
import Models.factory.KamerFactory;
import Models.kamers.*;

import java.util.ArrayList;
import java.util.Random;

public class Studio extends Woning{
    /* studio bestaat uit maximaal 1 woonkamer, 1 keuken, 1 badkamer, 1 slaapkamer en 1 balkon */
    private final int aantalWoonkamers = 1;
    private final int aantalKeukens = 1;
    private final int aantalSlaapkamers = 1;
    private final int aantalBadkamers = 1;
    private int aantalBalkon = 0;
    private Random random = new Random();

    public Studio(){
        ArrayList<Kamer> kamers = new ArrayList<Kamer>();
        /* Aanmaak van de woonkamer */
        kamers.add(KamerFactory.createKamer(KamerEnum.Woonkamer.getKamer(), 20,30));

        /* Aanmaak van de keuken */
        kamers.add(KamerFactory.createKamer(KamerEnum.Keuken.getKamer(), 15,20));

        /* Aanmaak van de slaapkamer */
        kamers.add(KamerFactory.createKamer(KamerEnum.Slaapkamer.getKamer(), 15,10));

        /* Aanmaak van de badkamer */
        kamers.add(KamerFactory.createKamer(KamerEnum.Badkamer.getKamer(), 15,15));

        /* Aanmaak van de balkon */
        aantalBalkon += random.nextInt(2);
        for(int x = 0; x < aantalBalkon; x++){
            kamers.add(KamerFactory.createKamer(KamerEnum.Balkon.getKamer(), 20,20));
        }

        setKamers(kamers);
        setPrijsWonging(this.calPrijsWoning());
    }

    public Object[][] getOutput() {
        Object[][] output = {
                {"Studio", "Woonkamer", aantalWoonkamers},
                {" ", "Slaapkamer", aantalSlaapkamers},
                {" ", "Keuken", aantalKeukens},
                {" ", "Badkamers", aantalBadkamers},
                {" ", "Balkon", aantalBalkon},
                {" ", " ", " "},
                {"", "Prijs: ", String.format("%-5s", String.format("%1.2f", getPrijsWonging()))},
                {" ", " ", " "},
        };
        return output;
    }

    public double calPrijsWoning() {
        ArrayList<Kamer> kamers = getKamers();
        double output = EenheidsprijsEnum.Studio.getPrijs();
        int oppervlakte = 0;
        double bijkomendePrijs = 1.00;

        for (Kamer k: kamers) {
            oppervlakte += k.getOppervlakte();
            if(k instanceof Balkon){
                bijkomendePrijs += 0.025;
            }
        }
        output = (output * oppervlakte) * bijkomendePrijs;

        return output;
    }

    @Override
    public String toString() {
        return "Studio";
    }
}
