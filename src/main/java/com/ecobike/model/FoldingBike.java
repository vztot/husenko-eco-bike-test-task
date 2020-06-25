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
    private Integer weight;
    private Boolean lights;
    private String color;
    private Integer price;
    private Integer wheelSize;
    private Integer numberOfGears;

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

    public Integer getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(Integer wheelSize) {
        this.wheelSize = wheelSize;
    }

    public Integer getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(Integer numberOfGears) {
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

        FoldingBike that = (FoldingBike) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) {
            return false;
        }
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) {
            return false;
        }
        if (lights != null ? !lights.equals(that.lights) : that.lights != null) {
            return false;
        }
        if (color != null ? !color.equals(that.color) : that.color != null) {
            return false;
        }
        if (price != null ? !price.equals(that.price) : that.price != null) {
            return false;
        }
        if (wheelSize != null ? !wheelSize.equals(that.wheelSize) : that.wheelSize != null) {
            return false;
        }
        return numberOfGears != null ? numberOfGears.equals(that.numberOfGears)
                : that.numberOfGears == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 37 * result + (weight != null ? weight.hashCode() : 0);
        result = 41 * result + (lights != null ? lights.hashCode() : 0);
        result = 43 * result + (color != null ? color.hashCode() : 0);
        result = 47 * result + (price != null ? price.hashCode() : 0);
        result = 53 * result + (wheelSize != null ? wheelSize.hashCode() : 0);
        result = 59 * result + (numberOfGears != null ? numberOfGears.hashCode() : 0);
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

    public String toCatalogString() {
        return "FOLDING BIKE " + brand + " with " + numberOfGears + " gear(s) and "
                + (lights ? "" : "no") + " head/tail light.\nPrice: " + price + " euros.";
    }
}
