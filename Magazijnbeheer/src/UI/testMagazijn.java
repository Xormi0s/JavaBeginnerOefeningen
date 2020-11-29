package UI;

import Factory.ProductFactory;
import Factory.StockFactory;
import Models.Product;
import Models.Stock;
import Enum.StockBewegingInEnum;
import Enum.StockBewegingUitEnum;

import java.util.Iterator;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class testMagazijn {

    public static void main(String[] args) {
        SortedSet<Product> producten = new TreeSet<Product>();
        Random random = new Random();
        /* Maximaal 5 omwille van unieke producten */
        int aantalProducten = 3;
        /* Aantal stockbewegingen naar keuze */
        int aantalStock = 4;

        for (int x = 0; x < aantalProducten; x++) {
            int minStock = 2 + random.nextInt(10);
            int maxStock = 20 + random.nextInt(50);
            boolean uniek = false;
            while (!uniek) {
                int soortProduct = random.nextInt(5);
                Product product = ProductFactory.createProduct(soortProduct, minStock, maxStock);
                /* Initiële stock word direct bij aanmaak van een product gemaakt. Initstock is voor een willekeurige getal tussen min en max stock */
                int initStock = product.getMinStock() + (maxStock/2);
                product.addStockBeweging(StockFactory.initieleStock(initStock));
                if (producten.add(product)) {
                    uniek = true;
                }
            }
        }

        Iterator iterator = producten.iterator();
        while (iterator.hasNext()) {
            Product productTemp = (Product) iterator.next();
            System.out.println(productTemp);
            for (int x = 0; x < aantalStock; x++) {
                int randomAantal = 1 + random.nextInt((productTemp.getMaxstock()/4));
                productTemp.addStockBeweging(StockFactory.createStock(random.nextInt(6), randomAantal));
            }
        }
    }
}
