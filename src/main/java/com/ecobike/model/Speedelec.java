package com.ecobike.model;

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
    private Integer weight;
    private Boolean lights;
    private String color;
    private Integer price;
    private Integer maximumSpeed;
    private Integer batteryCapacity;

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Boolean hasLights() {
        return lights;
    }

    public void setLights(Boolean lights) {
        this.lights = lights;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
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

        if (id != null ? !id.equals(speedelec.id) : speedelec.id != null) {
            return false;
        }
        if (brand != null ? !brand.equals(speedelec.brand) : speedelec.brand != null) {
            return false;
        }
        if (weight != null ? !weight.equals(speedelec.weight) : speedelec.weight != null) {
            return false;
        }
        if (lights != null ? !lights.equals(speedelec.lights) : speedelec.lights != null) {
            return false;
        }
        if (color != null ? !color.equals(speedelec.color) : speedelec.color != null) {
            return false;
        }
        if (price != null ? !price.equals(speedelec.price) : speedelec.price != null) {
            return false;
        }
        if (maximumSpeed != null ? !maximumSpeed.equals(speedelec.maximumSpeed)
                : speedelec.maximumSpeed != null) {
            return false;
        }
        return batteryCapacity != null ? batteryCapacity.equals(speedelec.batteryCapacity)
                : speedelec.batteryCapacity == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 37 * result + (weight != null ? weight.hashCode() : 0);
        result = 41 * result + (lights != null ? lights.hashCode() : 0);
        result = 43 * result + (color != null ? color.hashCode() : 0);
        result = 47 * result + (price != null ? price.hashCode() : 0);
        result = 53 * result + (maximumSpeed != null ? maximumSpeed.hashCode() : 0);
        result = 59 * result + (batteryCapacity != null ? batteryCapacity.hashCode() : 0);
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

    public String toCatalogString() {
        return "SPEEDELEC " + brand + " with " + batteryCapacity + " mAh battery and "
                + (lights ? "" : "no") + " head/tail light.\nPrice: " + price + " euros.";
    }
}
