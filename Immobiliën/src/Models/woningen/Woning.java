package Models.woningen;

import Models.kamers.Kamer;

import java.util.ArrayList;

public abstract class Woning {
    private double prijsWonging;
    private ArrayList<Kamer> kamers = new ArrayList<Kamer>();


    public void setPrijsWonging(double prijsWonging) {
        this.prijsWonging = prijsWonging;
    }

    public double getPrijsWonging() {
        return this.prijsWonging;
    }

    public ArrayList<Kamer> getKamers() {
        return kamers;
    }

    public void setKamers(ArrayList<Kamer> kamers) {
        this.kamers = kamers;
    }
}
