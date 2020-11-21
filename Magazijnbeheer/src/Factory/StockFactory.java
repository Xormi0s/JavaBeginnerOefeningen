package Factory;

import Models.Product;
import Models.Stock;
import Enum.StockBewegingInEnum;
import Enum.StockBewegingUitEnum;

public class StockFactory {

    public static Stock createStock(int type, int aantal){
        Stock stock = new Stock();
        switch (type){
            case 0:
                stock.IN(StockBewegingInEnum.productie, aantal);
                return stock;
            case 1:
                stock.IN(StockBewegingInEnum.levering, aantal);
                return stock;
            case 2:
                stock.OUT(StockBewegingUitEnum.reservatie, aantal);
                return stock;
            case 3:
                stock.OUT(StockBewegingUitEnum.verkoop, aantal);
                return stock;
            case 4:
                stock.OUT(StockBewegingUitEnum.quarantaine, aantal);
                return stock;
            case 5:
                stock.OUT(StockBewegingUitEnum.vernietiging, aantal);
                return stock;
            default:
                return null;
        }
    }

    public static Stock initieleStock(int aantal){
        Stock init = new Stock();
        init.IN(StockBewegingInEnum.productie, aantal);
        return init;
    }
}
