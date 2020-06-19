package com.ecobike.model.entity;

import com.ecobike.model.ClassicBike;
import java.math.BigDecimal;

public class FoldingBike extends ClassicBike {
    public FoldingBike(String brand, int weight, boolean lights, String color, BigDecimal price,
                       int wheelSize, int numberOfGears) {
        super(brand, weight, lights, color, price, wheelSize, numberOfGears);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
