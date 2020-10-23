package Models;

import Models.kamers.Badkamer;

public enum KamerEnum {
    Woonkamer(0),
    Keuken(1),
    Badkamer(2),
    Slaapkamer(3),
    Tuin(4),
    Garage(5),
    WC(6),
    Balkon(7),
    Berging(8);

    private final int i;

    KamerEnum(int i) {
        this.i = i;
    }

    public int getKamer(){
        return this.i;
    }
}
