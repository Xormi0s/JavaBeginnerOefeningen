package Factory;

import Models.Product;

public class ProductFactory {

    public static Product createProduct(int type, int min, int max){
        switch (type){
            case 0:
                return new Product(min,max,"Xbox Series X");
            case 1:
                return new Product(min,max,"Playstation 5");
            case 2:
                return new Product(min,max,"Nintendo Switch");
            case 3:
                return new Product(min,max,"LG 4K nanocell 65inch TV");
            case 4:
                return new Product(min,max,"LG 8K nanocell 75inch TV");
            default:
                return null;
        }
    }
}
