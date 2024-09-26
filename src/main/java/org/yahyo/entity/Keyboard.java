package org.yahyo.entity;

import java.util.Objects;

public class Keyboard extends Computer{
    private String layout;

    public Keyboard(int id, float price, String brand, String durability, String layout) {
        super(id, price, brand, durability);
        this.layout = layout;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Keyboard keyboard = (Keyboard) o;
        return Objects.equals(layout, keyboard.layout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), layout);
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                super.toString() +
                ", layout='" + layout + '\'' +
                '}';
    }
}
