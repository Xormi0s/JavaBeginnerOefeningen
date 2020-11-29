package Factory;

import Models.Stock;
import Enum.StockBewegingInEnum;
import Enum.StockBewegingUitEnum;

public class StockFactory {

    public static Stock createStock(int type, int aantal){
        Stock stock = new Stock();
        switch (type){
            case 0:
                stock.IN(StockBewegingInEnum.Productie, aantal);
                return stock;
            case 1:
                stock.IN(StockBewegingInEnum.Levering, aantal);
                return stock;
            case 2:
                stock.OUT(StockBewegingUitEnum.Reservatie, aantal);
                return stock;
            case 3:
                stock.OUT(StockBewegingUitEnum.Verkoop, aantal);
                return stock;
            case 4:
                stock.OUT(StockBewegingUitEnum.Quarantaine, aantal);
                return stock;
            case 5:
                stock.OUT(StockBewegingUitEnum.Vernietiging, aantal);
                return stock;
            default:
                return null;
        }
    }

    public static Stock initieleStock(int aantal){
        Stock init = new Stock();
        init.IN(StockBewegingInEnum.Productie, aantal);
        return init;
    }
}
