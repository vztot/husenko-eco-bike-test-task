package com.ecobike.model;

import java.math.BigDecimal;
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
    private BigDecimal price;
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

        FoldingBike folding = (FoldingBike) o;

        if (weight != folding.weight) {
            return false;
        }
        if (lights != folding.lights) {
            return false;
        }
        if (wheelSize != folding.wheelSize) {
            return false;
        }
        if (numberOfGears != folding.numberOfGears) {
            return false;
        }
        if (id != null ? !id.equals(folding.id) : folding.id != null) {
            return false;
        }
        if (brand != null ? !brand.equals(folding.brand) : folding.brand != null) {
            return false;
        }
        if (color != null ? !color.equals(folding.color) : folding.color != null) {
            return false;
        }
        return price != null ? price.equals(folding.price) : folding.price == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 37 * result + weight;
        result = 41 * result + (lights ? 1 : 0);
        result = 43 * result + (color != null ? color.hashCode() : 0);
        result = 47 * result + (price != null ? price.hashCode() : 0);
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
