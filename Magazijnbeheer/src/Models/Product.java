package Models;

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
            if(stockBewegingen.getPositief() >= 1){
                aantal += stockBewegingen.getPositief();
            } else {
                aantal -= stockBewegingen.getNegatief();
            }
        }
        return aantal;
    }

    public void addStockBeweging(Stock stock){
        String output = "\t* " + stock.toString();
        int posTotaal = stock.getPositief() + beschikbareHoeveelheid();
        int negTotaal = beschikbareHoeveelheid() - stock.getNegatief();
        if(status != null){
            String checkStatus = status.getStatus();
            switch (checkStatus){
                case "critical":
                    if(stock.getPositief() >= 1 && posTotaal <= maxstock){
                        stockBewegingen.add(stock);
                        System.out.println(output + " stock aangepast");
                    }
                    if(stock.getPositief() >= 1 && posTotaal > maxstock){
                        System.out.println(output + " verhoging geweigerd");
                    }
                    if(stock.getNegatief() > 0 && negTotaal >= criticalStock){
                        stockBewegingen.add(stock);
                        System.out.println(output + " stock aangepast");
                    }
                    else if(stock.getNegatief() > 0 && negTotaal <= criticalStock) {
                        System.out.println(output +  " verlaging geweigerd");
                    }
                    break;
                case "high":
                    if(stock.getPositief() >= 1 && posTotaal <= maxstock){
                        stockBewegingen.add(stock);
                        System.out.println(output + " stock aangepast");
                    }
                    if(stock.getPositief() >= 1 && posTotaal > maxstock){
                        System.out.println(output + " verhoging geweigerd");
                    }
                    if(stock.getNegatief() > 0 && negTotaal >= criticalStock){
                        stockBewegingen.add(stock);
                        System.out.println(output + " stock aangepast");
                    }
                    else if(stock.getNegatief() > 0 && negTotaal <= criticalStock) {
                        System.out.println(output +  " verlaging geweigerd");
                    }
                    break;
                /* default omdat low en normal zelfde zijn */
                default:
                    if(stock.getPositief() >= 1 && posTotaal <= maxstock) {
                        stockBewegingen.add(stock);
                        System.out.println(output + " stock aangepast");
                    }
                    if(stock.getPositief() >= 1 && posTotaal > maxstock){
                        System.out.println(output + " verhoging geweigerd");
                    }
                    if(stock.getNegatief() > 0 &&  negTotaal >= criticalStock){
                        stockBewegingen.add(stock);
                        System.out.println(output + " stock aangepast");
                    }
                    else if(stock.getNegatief() > 0 &&  negTotaal <= criticalStock) {
                        System.out.println(output +  " verlaging geweigerd");
                    }
            }
            setStatus();
            System.out.println("\t  " + status);
        } else {
            stockBewegingen.add(stock);
            setStatus();
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
        return "Product: " + productOmschrijving;
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
