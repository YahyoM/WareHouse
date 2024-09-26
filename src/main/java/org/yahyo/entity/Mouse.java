package org.yahyo.entity;

import java.util.Objects;

public class Mouse extends Computer{
    private String connectivity;

    public Mouse(int id, float price, String brand, String durability, String connectivity) {
        super(id, price, brand, durability);
        this.connectivity = connectivity;
    }

    public String getConnectivity() {
        return connectivity;
    }

    public void setConnectivity(String connectivity) {
        this.connectivity = connectivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mouse mouse = (Mouse) o;
        return Objects.equals(connectivity, mouse.connectivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), connectivity);
    }

    @Override
    public String toString() {
        return "Mouse{" +
                super.toString() +
                ", connectivity='" + connectivity + '\'' +
                '}';
    }
}
