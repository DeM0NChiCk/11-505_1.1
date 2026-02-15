package enums;

import model.Product;
import service.Storage;

public enum ShopEnum{
    BUY_PRODUCT{
        @Override
        public void action(Product[] products, Product product, Storage storage) {
            storage.addProduct(products, product);
        }
    };
    public abstract void action(Product[] products, Product product, Storage storage);

}
