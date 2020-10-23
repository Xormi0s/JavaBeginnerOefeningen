package Models.factory;

import Models.woningen.*;

public class WoningFactory {

    public static Woning createWoning(int x){
        switch (x){
            case 0:
                return new Villa();
            case 1:
                return new Huis();
            case 2:
                return new Appartement();
            case 3:
                return new Studio();
            default:
                return null;
        }
    }
}
