package Models;

import Exceptions.stockCritException;
import Exceptions.stockException;
import Exceptions.stockHighException;

import java.awt.*;
import java.io.Console;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Objects;

public class Product implements Comparable{
    private LinkedList<Stock> stockBewegingen = new LinkedList<Stock>();
    private int minStock;
    private int maxstock;
    private int criticalStock;
    private String productOmschrijving;
    private Status status;

    public Product(int minStock, int maxStock, String productOmschrijving ) {
        this.minStock = minStock;
        this.maxstock = maxStock;
        if(minStock > 2){
            this.criticalStock = (minStock/2);
        } else {
            this.criticalStock = 0;
        }
        this.productOmschrijving = productOmschrijving;
    }

    public int getMinStock() {
        return minStock;
    }

    public int getMaxstock() {
        return maxstock;
    }

    public int getCriticalStock() {
        return criticalStock;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus() {
        int aantal = beschikbareHoeveelheid();
        if(aantal < minStock){
            status = new StatusCritical();
        }
        if(aantal >= minStock && aantal < (maxstock/2)){
            status = new StatusLow();
        }
        if(aantal < maxstock && aantal >= (maxstock/2)){
            status = new StatusNormal();
        }
        if(aantal >= (maxstock/2)+(maxstock/4) && aantal <= maxstock){
            status = new StatusHigh();
        }
    }

    public int beschikbareHoeveelheid(){
        int aantal = 0;
        for(Stock stockBewegingen: stockBewegingen){
            aantal += stockBewegingen.getTotaal();
        }
        return aantal;
    }

    public void addStockBeweging(Stock stock) {

        String output = "\t* " + stock.toString();
        int totaal = beschikbareHoeveelheid() + stock.getTotaal();
        /* Initialisatie van stock */
        if(status == null){
            stockBewegingen.add(stock);
            /* Console output blokkeren door nieuwe printstream aan te maken. Dit zodat bij initialiseren van stock geen overbodige text word getoont */
            PrintStream printStreamOriginal = System.out;
            System.setOut(new PrintStream(new OutputStream(){
                public void write(int b) {
                }
            }));
            setStatus();
            /* Terug zetten naar originele printstream */
            System.setOut(printStreamOriginal);
        } else if (status != null) {
            try{
                if (totaal >= criticalStock && totaal <= maxstock) {
                    stockBewegingen.add(stock);
                    System.out.println(output + " stock aangepast");
                }
                if (totaal > maxstock) {
                    throw new stockHighException(output);
                } if (totaal < criticalStock) {
                    throw new stockCritException(output);
                }
            } catch (stockException e){
                System.out.println(e.getMessage());
            } finally {
                setStatus();
                System.out.println("\t  " + status);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return productOmschrijving.equals(product.productOmschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productOmschrijving);
    }

    @Override
    public String toString() {
        return "Product: " + productOmschrijving + " --- min: " + minStock + " max: " + maxstock;
    }

    @Override
    public int compareTo(Object o) {
        if(this.equals(o)){
            return 0;
        } else {
            return 1;
        }
    }
}
