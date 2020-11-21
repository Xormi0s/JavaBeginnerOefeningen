package Models;
import Enum.StockBewegingUitEnum;
import Enum.StockBewegingInEnum;

public class Stock {
    private String beweging;
    private int positief = 0;
    private int negatief = 0;

    public Stock() {

    }

    public void IN(StockBewegingInEnum bewegingIn, int aantal){
        this.beweging = bewegingIn.toString();
        this.positief = aantal;
    }
    public void OUT(StockBewegingUitEnum bewegingUit, int aantal){
        this.beweging = bewegingUit.toString();
        this.negatief = aantal;
    }

    public int getPositief() {
        return positief;
    }

    public int getNegatief() {
        return negatief;
    }

    public String getBeweging() {
        return beweging;
    }

    @Override
    public String toString() {
        int aantal = 0;
        String plusOfMin = "-";
        if(positief >= 1){
            plusOfMin = "+";
            aantal = positief;
        } else {
            aantal = negatief;
        }
        return plusOfMin + aantal + ", " + beweging + ",";
    }
}
