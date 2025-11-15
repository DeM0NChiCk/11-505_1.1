package model;

public class Chesspiece {
    private String color;
    private int x;
    private int y;
    private boolean status = false;
    private String title;

    {
        status = true;
    }

    public Chesspiece(String color, int x, int y, String title) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getRealX() {
        if (this.x < -1) {
            return -1;
        }
        return this.x;
    }

    public int getY() {
        return y;
    }

    public boolean getStatus () {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
