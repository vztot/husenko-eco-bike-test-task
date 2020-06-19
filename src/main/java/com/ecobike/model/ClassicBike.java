package com.ecobike.model;

import java.math.BigDecimal;

public abstract class ClassicBike extends Bike {
    private int wheelSize;
    private int numberOfGears;

    public ClassicBike(String brand, int weight, boolean lights, String color, BigDecimal price,
                       int wheelSize, int numberOfGears) {
        super(brand, weight, lights, color, price);
        this.wheelSize = wheelSize;
        this.numberOfGears = numberOfGears;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        this.numberOfGears = numberOfGears;
    }
}
