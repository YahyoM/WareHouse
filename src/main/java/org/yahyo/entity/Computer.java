package org.yahyo.entity;

import java.util.Objects;

public abstract class Computer {
    private int id;
    private float price;
    private String brand;
    private String durability;

    public Computer(int id, float price, String brand, String durability) {
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.durability = durability;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return id == computer.id && Float.compare(price, computer.price) == 0 && Objects.equals(brand, computer.brand) && Objects.equals(durability, computer.durability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, brand, durability);
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                ", durability='" + durability + '\'';
    }
}
