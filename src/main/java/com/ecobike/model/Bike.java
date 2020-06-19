package com.ecobike.model;

import java.math.BigDecimal;

public abstract class Bike implements Comparable {

    /*
    I Decided made Bike (contains common properties for all types), ClassicBike (properties for
    classic bikes), ElectricBike(properties for electric bikes) as abstract classes because
    abstract classes represent properties but nor behavior, and made implementations of models as
    default classes.

    I didn't use interfaces because models dont have behaviour. I know that this division between
    abstract classes and interfaces are depends on conditions and environment, but for this task
    particularly i like this solution.
    */

    private String brand;
    private int weight;
    private boolean lights;
    private String color;
    private BigDecimal price;

    public Bike(String brand, int weight, boolean lights, String color, BigDecimal price) {
        this.brand = brand;
        this.weight = weight;
        this.lights = lights;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isLights() {
        return lights;
    }

    public void setLights(boolean lights) {
        this.lights = lights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
