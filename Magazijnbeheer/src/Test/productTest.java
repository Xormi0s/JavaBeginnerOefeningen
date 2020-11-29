package Test;
import Factory.StockFactory;
import Models.Product;
import Models.Stock;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import Enum.StockBewegingUitEnum;
import Enum.StockBewegingInEnum;
import org.junit.jupiter.api.BeforeEach;

public class productTest {
    private Product product;

    @BeforeEach
    public void setUp() throws Exception{
        product = new Product(6, 30, "Iphone 12");
        Stock init = StockFactory.initieleStock(8);
        product.addStockBeweging(init);
    }

    @Test
    public void testStockBewegingCriticalOUT(){
        Stock stock = new Stock();
        stock.OUT(StockBewegingUitEnum.Verkoop,5);
        product.addStockBeweging(stock);
        String output = product.getStatus().toString();
        output = output.substring(14,22);

        assertEquals("Critical", output);
        assertEquals(3,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingCriticalOUTGeweigerd(){
        Stock stock1 = new Stock();
        stock1.OUT(StockBewegingUitEnum.Verkoop,5);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 6);
        product.addStockBeweging(stock2);

        assertEquals(3,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingCriticalIN(){
        Stock stock1 = new Stock();
        stock1.OUT(StockBewegingUitEnum.Verkoop,5);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.IN(StockBewegingInEnum.Levering, 8);
        product.addStockBeweging(stock2);
        String output = product.getStatus().toString();
        output = output.substring(14,17);

        assertEquals("Low", output);
        assertEquals(11,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingCriticalINGeweigerd(){
        Stock stock1 = new Stock();
        stock1.OUT(StockBewegingUitEnum.Verkoop,5);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.IN(StockBewegingInEnum.Levering,30);
        product.addStockBeweging(stock2);
        String output = product.getStatus().toString();
        output = output.substring(14,22);

        assertEquals("Critical", output);
        assertEquals(3,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingLow(){
        String output = product.getStatus().toString();
        output = output.substring(14,17);

        assertEquals("Low", output);
        assertEquals(8,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingLowIN(){
        Stock stock = new Stock();
        stock.IN(StockBewegingInEnum.Levering, 8);
        product.addStockBeweging(stock);
        String output = product.getStatus().toString();
        output = output.substring(14,20);

        assertEquals("Normal", output);
        assertEquals(16,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingLowINGeweigerd(){
        Stock stock = new Stock();
        stock.IN(StockBewegingInEnum.Levering, 35);
        product.addStockBeweging(stock);
        String output = product.getStatus().toString();
        output = output.substring(14,17);

        assertEquals("Low", output);
        assertEquals(8,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingLowOUT(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 4);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 6);
        product.addStockBeweging(stock2);

        assertEquals(6,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingLowOUTGeweigerd(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 4);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 10);
        product.addStockBeweging(stock2);

        assertEquals(12,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingNormal(){
        Stock stock = new Stock();
        stock.IN(StockBewegingInEnum.Levering, 8);
        product.addStockBeweging(stock);
        String output = product.getStatus().toString();
        output = output.substring(14,20);

        assertEquals("Normal", output);
        assertEquals(16,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingNormalIN(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 8);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.IN(StockBewegingInEnum.Levering, 3);
        product.addStockBeweging(stock2);
        String output = product.getStatus().toString();
        output = output.substring(14,20);

        assertEquals("Normal", output);
        assertEquals(19,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingNormalINGeweigerd(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 8);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.IN(StockBewegingInEnum.Levering, 25);
        product.addStockBeweging(stock2);
        String output = product.getStatus().toString();
        output = output.substring(14,20);

        assertEquals("Normal", output);
        assertEquals(16,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingNormalOUT(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 12);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 4);
        product.addStockBeweging(stock2);

        assertEquals(16,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingNormalOUTGeweigerd(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 12);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 25);
        product.addStockBeweging(stock2);

        assertEquals(20,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingHigh(){
        Stock stock = new Stock();
        stock.IN(StockBewegingInEnum.Levering, 20);
        product.addStockBeweging(stock);
        String output = product.getStatus().toString();
        output = output.substring(14,18);

        assertEquals("High", output);
        assertEquals(28,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingHighIN(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 20);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.IN(StockBewegingInEnum.Levering, 2);
        product.addStockBeweging(stock2);
        String output = product.getStatus().toString();
        output = output.substring(14,18);

        assertEquals("High", output);
        assertEquals(30,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingHighINGeweigerd(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 20);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.IN(StockBewegingInEnum.Levering, 7);
        product.addStockBeweging(stock2);
        String output = product.getStatus().toString();
        output = output.substring(14,18);

        assertEquals("High", output);
        assertEquals(28,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingHighOUT(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 20);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 8);
        product.addStockBeweging(stock2);

        assertEquals(20,product.beschikbareHoeveelheid());
    }

    @Test
    public void testStockBewegingHighOUTGeweigerd(){
        Stock stock1 = new Stock();
        stock1.IN(StockBewegingInEnum.Levering, 20);
        product.addStockBeweging(stock1);
        Stock stock2 = new Stock();
        stock2.OUT(StockBewegingUitEnum.Verkoop, 30);
        product.addStockBeweging(stock2);

        assertEquals(28,product.beschikbareHoeveelheid());
    }
}
