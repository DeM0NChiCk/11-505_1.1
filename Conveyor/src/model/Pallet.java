package model;

public class Pallet<T extends Box> {
    private final String id;
    private final double maxVolume;
//    private final Box[] storage;
    private final T[] storage;
    private int count;
    private double currentVolume = 0;
    private boolean isFull = false;

//    public Pallet(String id, double maxVolume, int capacity) {
//        this.id = id;
//        this.maxVolume = maxVolume;
//        this.storage = new Box[capacity];
//    }

    public Pallet(String id, double maxVolume, T[] box) {
        this.id = id;
        this.maxVolume = maxVolume;
        this.storage = box;
    }

    public boolean addBox(T box) {
        if (isFull) return false;
        if (currentVolume + box.getVolume() > maxVolume) return false;
        if (count >= storage.length) {
            isFull = true;
            return false;
        }

        storage[count] = box;
        currentVolume += box.getVolume();
        count++;

        if (currentVolume >= maxVolume * 0.95) {
            isFull = true;
        }

        return true;
    }

//    public T getBox(int index) {
//        if (index < 0 || index >= count) return null;
//
//        return (T) storage[index];
//    }

    public T getBox(int index) {
        if (index < 0 || index >= count) return null;

        return storage[index];
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return isFull;
    }

    public String getId() {
        return id;
    }

    public double getRemainingVolume() {
        return maxVolume - currentVolume;
    }
}
