package com.ecobike.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "speedelecs")
public class Speedelec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int weight;
    private boolean lights;
    private String color;
    private BigDecimal price;
    private int maximumSpeed;
    private int batteryCapacity;

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

    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
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

        Speedelec speedelec = (Speedelec) o;

        if (weight != speedelec.weight) {
            return false;
        }
        if (lights != speedelec.lights) {
            return false;
        }
        if (maximumSpeed != speedelec.maximumSpeed) {
            return false;
        }
        if (batteryCapacity != speedelec.batteryCapacity) {
            return false;
        }
        if (id != null ? !id.equals(speedelec.id) : speedelec.id != null) {
            return false;
        }
        if (brand != null ? !brand.equals(speedelec.brand) : speedelec.brand != null) {
            return false;
        }
        if (color != null ? !color.equals(speedelec.color) : speedelec.color != null) {
            return false;
        }
        return price != null ? price.equals(speedelec.price) : speedelec.price == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 37 * result + weight;
        result = 41 * result + (lights ? 1 : 0);
        result = 43 * result + (color != null ? color.hashCode() : 0);
        result = 47 * result + (price != null ? price.hashCode() : 0);
        result = 53 * result + maximumSpeed;
        result = 59 * result + batteryCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "Speedelec{"
                + "id=" + id
                + ", brand='" + brand + '\''
                + ", weight=" + weight
                + ", lights=" + lights
                + ", color='" + color + '\''
                + ", price=" + price
                + ", maximumSpeed=" + maximumSpeed
                + ", batteryCapacity=" + batteryCapacity
                + '}';
    }
}
