package com.ecobike.model.entity;

import com.ecobike.model.ElectricBike;
import java.math.BigDecimal;

public class Speedelec extends ElectricBike {
    public Speedelec(String brand, int weight, boolean lights, String color, BigDecimal price,
                     int maximumSpeed, int batteryCapacity) {
        super(brand, weight, lights, color, price, maximumSpeed, batteryCapacity);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
