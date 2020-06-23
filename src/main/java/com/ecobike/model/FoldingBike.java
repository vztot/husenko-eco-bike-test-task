package com.ecobike.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "folding_bikes")
public class FoldingBike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int weight;
    private boolean lights;
    private String color;
    private int price;
    private int wheelSize;
    private int numberOfGears;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean hasLights() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        FoldingBike foldingBike = (FoldingBike) o;

        if (weight != foldingBike.weight) {
            return false;
        }
        if (lights != foldingBike.lights) {
            return false;
        }
        if (price != foldingBike.price) {
            return false;
        }
        if (wheelSize != foldingBike.wheelSize) {
            return false;
        }
        if (numberOfGears != foldingBike.numberOfGears) {
            return false;
        }
        if (id != null ? !id.equals(foldingBike.id) : foldingBike.id != null) {
            return false;
        }
        if (brand != null ? !brand.equals(foldingBike.brand) : foldingBike.brand != null) {
            return false;
        }
        return color != null ? color.equals(foldingBike.color) : foldingBike.color == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 37 * result + weight;
        result = 41 * result + (lights ? 1 : 0);
        result = 43 * result + (color != null ? color.hashCode() : 0);
        result = 47 * result + price;
        result = 53 * result + wheelSize;
        result = 59 * result + numberOfGears;
        return result;
    }

    @Override
    public String toString() {
        return "FoldingBike{"
                + "id=" + id
                + ", brand='" + brand + '\''
                + ", weight=" + weight
                + ", lights=" + lights
                + ", color='" + color + '\''
                + ", price=" + price
                + ", wheelSize=" + wheelSize
                + ", numberOfGears=" + numberOfGears
                + '}';
    }
}
