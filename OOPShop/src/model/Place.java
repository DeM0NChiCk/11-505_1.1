package model;

public abstract class Place {
    private String address;
    private final String square;
    private String title;

    public Place(String address, String square, String title) {
        this.address = address;
        this.square = square;
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public String getSquare() {
        return square;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract String getTitle();

    public abstract void setTitle(String title);

}
