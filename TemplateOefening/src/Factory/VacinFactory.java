package Factory;

import Models.*;

public class VacinFactory {

    public static Vacin createVacin(int y, Persoon persoon){
        switch (y){
            case 0: return new Covid19(persoon);
            case 1: return new Influenza(persoon);
            case 2: return new Dtp(persoon);
            case 3: return new HepatitisB(persoon);
            default: return null;
        }
    }
}
