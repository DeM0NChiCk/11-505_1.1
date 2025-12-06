package model;

import service.VIPAService;
import service.VIPBService;

public final class VIP extends Client implements VIPAService, VIPBService {

    public boolean status = true;

    public VIP(int id, String country, int age, String username, String password, String address) {
        super(id, country, age, username, password, address);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void buyProductInShop(Product product, int count) {
        super.buyProductInShop(product, count);
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Я VIP");
    }

    @Override
    public void vipBuyA() {
        System.out.println("ВИП ФИЗ ЛИЦО ПОКУПАЕТ ТОВАР");

    }

    @Override
    public void vipOptBuyB() {
        System.out.println("ВИП ЮР ЛИЦО ПОКУПАЕТ ТОВАР");
    }
}
