package model;

public class StandardBox extends Box {
    private final int weight;
    public StandardBox(double length, double width, double height, int weight) {
        super(length, width, height);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}
