package org.yahyo.entity;

import java.util.Objects;

public class Monitor extends Computer{
    private String resolution;

    public Monitor(int id, float price, String brand, String durability, String resolution) {
        super(id, price, brand, durability);
        this.resolution = resolution;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monitor monitor = (Monitor) o;
        return Objects.equals(resolution, monitor.resolution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), resolution);
    }

    @Override
    public String toString() {
        return "Monitor{" +
                super.toString() +
                ", resolution='" + resolution + '\'' +
                '}';
    }
}
