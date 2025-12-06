package model;

import service.LoadService;

public class Storage extends Place implements LoadService {

    private Product[][] loc;

    public Storage(String address, String square, String title, int numberLocs, int column) {
        super(address, square, title);
        this.loc = new Product[numberLocs][column];
    }

    public Product[][] getLoc() {
        return loc;
    }
    // TODO: title + address
    @Override
    public String getTitle() {
        return "";
    }
    // TODO: Возможность изменять название магазина, есть только у Employee с job = "director"
    @Override
    public void setTitle(String title) {

    }

    @Override
    public void load(Product[] products) {
        System.out.println("Загрузка хранилища");
    }

    @Override
    public void vipOptBuyB() {
        System.out.println("Закупка товаров у вип поставщиков");
    }

    // TODO: добавить возможность пополнять склад
}
