package model;

public abstract class Box {
    private final double length, width, height;

    public Box(double length, double width, double height) {
        this.height = height;
        this.length = length;
        this.width = width;
    }

    public double getVolume() {
        return length * height * width;
    }

    @Override
    public String toString() {
        return "Box[V = " + String.format("%.0f", getVolume());
    }
}
