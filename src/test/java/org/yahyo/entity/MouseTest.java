package org.yahyo.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MouseTest {

    @Test
    void testMouseCreation() {
        Mouse mouse = new Mouse(1, 30, "Logitech", "Robust", "USB");
        assertNotNull(mouse);
        assertEquals(1, mouse.getId());
        assertEquals(30, mouse.getPrice(), 0.01);
        assertEquals("Logitech", mouse.getBrand());
        assertEquals("Robust", mouse.getDurability());
        assertEquals("USB", mouse.getConnectivity());
    }

    @Test
    void testMouseEqualityAndHashcode() {
        Mouse mouse1 = new Mouse(2, 50, "Razer", "Sturdy", "Bluetooth");
        Mouse mouse2 = new Mouse(2, 50, "Razer", "Sturdy", "Bluetooth");
        Mouse mouse3 = new Mouse(3, 25, "Corsair", "Durable", "USB");

        assertEquals(mouse1, mouse2);
        assertNotEquals(mouse1, mouse3);
        assertEquals(mouse1.hashCode(), mouse2.hashCode());
        assertNotEquals(mouse1.hashCode(), mouse3.hashCode());
    }

    @Test
    void testMouseToString() {
        Mouse mouse = new Mouse(4, 40, "SteelSeries", "Resilient", "Bluetooth");
        String expected = "Mouse{id=4, price=40.0, brand='SteelSeries', durability='Resilient', connectivity='Bluetooth'}";
        assertEquals(expected, mouse.toString());
    }
}
