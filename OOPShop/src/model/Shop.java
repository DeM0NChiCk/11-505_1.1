package model;

import service.LoadService;

import java.util.Arrays;

public class Shop extends Place implements LoadService {

    private Product[] stand;

    public Shop(String address, String square, String title, Product[] products) {
        super(address, square, title);
        this.stand = products;
    }

    // TODO: title
    @Override
    public String getTitle() {
        return "";
    }

    // TODO: Возможность изменять название магазина, есть только у Employee с job = "manager"
    @Override
    public void setTitle(String title) {

    }

    @Override
    public void load(Product[] products) {
        Product[] newProducts = Arrays.copyOf(stand, stand.length + products.length);
        int indexProducts = 0;
        for (int i = newProducts.length - 1; i > stand.length - 1; i--) {
            newProducts[i] = products[indexProducts];
            indexProducts++;
        }
        System.out.println(Arrays.toString(newProducts));

    }

    @Override
    public void vipOptBuyB() {
        System.out.println("Продажа продуктов вип клиентам");

    }

    // TODO:
    //  1) Добавить возможность продавать продукты оптом (return Product[])
    //  2) Пополнять магазин из склада
}
