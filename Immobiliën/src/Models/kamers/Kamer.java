package Models.kamers;

public abstract class Kamer {
    private int oppervlakte;

    public Kamer(int opp) {
        this.oppervlakte = opp;
    }

    public int getOppervlakte() {
        return oppervlakte;
    }

}
