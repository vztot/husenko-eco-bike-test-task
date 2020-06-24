package com.ecobike.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ebikes")
public class Ebike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private int weight;
    private boolean lights;
    private String color;
    private int price;
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

        Ebike ebike = (Ebike) o;

        if (weight != ebike.weight) {
            return false;
        }
        if (lights != ebike.lights) {
            return false;
        }
        if (price != ebike.price) {
            return false;
        }
        if (maximumSpeed != ebike.maximumSpeed) {
            return false;
        }
        if (batteryCapacity != ebike.batteryCapacity) {
            return false;
        }
        if (id != null ? !id.equals(ebike.id) : ebike.id != null) {
            return false;
        }
        if (brand != null ? !brand.equals(ebike.brand) : ebike.brand != null) {
            return false;
        }
        return color != null ? color.equals(ebike.color) : ebike.color == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 37 * result + weight;
        result = 41 * result + (lights ? 1 : 0);
        result = 43 * result + (color != null ? color.hashCode() : 0);
        result = 47 * result + price;
        result = 53 * result + maximumSpeed;
        result = 59 * result + batteryCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "Ebike{"
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

    public String toCatalogString() {
        return "EBIKE " + brand + " with " + batteryCapacity + " mAh battery and "
                + (lights ? "" : "no") + " head/tail light.\nPrice: " + price + " euros.";
    }
}
