package Models;

public enum EenheidsprijsEnum {
    Villa(1100),
    Huis(1100),
    Appartement(1075),
    Studio(1050);

    private final int i;

    EenheidsprijsEnum(int i) {
        this.i = i;
    }

    public int getPrijs(){
        return this.i;
    }
}
