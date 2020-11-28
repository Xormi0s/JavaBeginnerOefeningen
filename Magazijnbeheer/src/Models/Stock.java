package Models;
import Enum.StockBewegingUitEnum;
import Enum.StockBewegingInEnum;

public class Stock {
    private String beweging;
    private int totaal = 0;

    public Stock() {

    }

    public void IN(StockBewegingInEnum bewegingIn, int aantal){
        this.beweging = bewegingIn.toString();
        this.totaal = aantal;
    }
    public void OUT(StockBewegingUitEnum bewegingUit, int aantal){
        this.beweging = bewegingUit.toString();
        this.totaal = -aantal;
    }

    public int getTotaal() {
        return totaal;
    }

    public String getBeweging() {
        return beweging;
    }

    @Override
    public String toString() {
        String plusOfMin = "";
        if(totaal >= 1){
            plusOfMin = "+";
        }
        return plusOfMin + totaal + ", " + beweging + ",";
    }
}
