package model;

import enums.FragilityLevel;

public class FragileBox extends Box{
    private final FragilityLevel fragilityLevel;

    public FragileBox(double length, double width, double height, FragilityLevel fragilityLevel) {
        super(length, width, height);
        if (super.getVolume() > 100) {
            throw new IllegalArgumentException("Параметры не соответствуют хрупкой коробки");
        }
        this.fragilityLevel = fragilityLevel;
    }

    public FragilityLevel getFragilityLevel() {
        return fragilityLevel;
    }

    @Override
    public String toString() {
        return "FragileBox[V = " + String.format("%.0f", getVolume()) + "Lvl = " + fragilityLevel.name() + "]";
    }
}
