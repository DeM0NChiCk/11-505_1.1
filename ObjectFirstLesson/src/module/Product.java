package module;

public class Product {
    public static int counterProducts = 0;
    private String name;
    private int position;
    private int count;

    {
        counterProducts++;
    }

    public Product(String name, int position, int count) {
        this.name = name;
        this.position = position;
        this.count = count;
    }

    public String getName(){
        return name;
    }

    public int getPosition(){
        return position;
    }

    public int getCount(){
        return count;
    }

    public void addOne(){
        this.count++;
    }

    public void removeOne(){
        if (this.count > 0)
            this.count--;
    }

}
