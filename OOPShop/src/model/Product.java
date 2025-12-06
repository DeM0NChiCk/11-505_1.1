package model;

public class Product {
    private String name = "нет имени";
    private final int position;
    private int count = 0;
    private double price = 1;

    public final String TAG = "Product: %s".formatted(name);

    public static int countAll;

    public static void setCountAll(int count) {
        countAll+=count;
    }

    public Product(String name, int position, int count) {
        this.count = Math.max(count, 0);
        this.position = position;
        this.name = name;
        price = price*count;
    }

    public Product(String name, int position, int count, double price) {
        this.count = Math.max(count, 0);
        this.position = position;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int position, double price) {
        this.position = position;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getPosition() {
        return position;
    }

    public double getPrice() {
        return price;
    }

    public int setPosition() {
        return this.position;
    }

    public void addOne() {
        this.count++;
        countAll++;
    }

    public void removeOne() {
        if (count == 0) {
            throw new IllegalArgumentException("Количество товара не может быть меньше 0.");
        }
        this.count--;
        countAll--;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
