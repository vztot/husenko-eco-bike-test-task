package com.ecobike.model;

import java.math.BigDecimal;

public abstract class ElectricBike extends Bike {
    private int maximumSpeed;
    private int batteryCapacity;

    public ElectricBike(String brand, int weight, boolean lights, String color, BigDecimal price,
                        int maximumSpeed, int batteryCapacity) {
        super(brand, weight, lights, color, price);
        this.maximumSpeed = maximumSpeed;
        this.batteryCapacity = batteryCapacity;
    }
}
