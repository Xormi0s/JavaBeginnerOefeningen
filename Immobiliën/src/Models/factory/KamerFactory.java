package Models.factory;

import Models.kamers.*;

import java.util.Random;

public class KamerFactory {

    public static Kamer createKamer(int type, int min, int max){
        Random random = new Random();
        switch(type){
            case 0:
                return new Woonkamer(min + random.nextInt(max));
            case 1:
                return  new Keuken(min + random.nextInt(max));
            case 2:
                return new Badkamer(min + random.nextInt(max));
            case 3:
                return new Slaapkamer(min + random.nextInt(max));
            case 4:
                return new Tuin(min + random.nextInt(max));
            case 5:
                return new Garage(min + random.nextInt(max));
            case 6:
                return new Wc(min + random.nextInt(max));
            case 7:
                return new Balkon(min + random.nextInt(max));
            case 8:
                return new Berging(min + random.nextInt(max));
            default:
                return null;
        }
    }
}
