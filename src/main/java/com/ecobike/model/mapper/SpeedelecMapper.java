package com.ecobike.model.mapper;

import com.ecobike.model.ElectricBike;
import java.math.BigDecimal;

public class SpeedelecMapper extends ElectricBike {
    public SpeedelecMapper(String brand, int weight, boolean lights, String color, BigDecimal price,
                           int maximumSpeed, int batteryCapacity) {
        super(brand, weight, lights, color, price, maximumSpeed, batteryCapacity);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
