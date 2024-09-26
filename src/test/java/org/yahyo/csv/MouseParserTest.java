package org.yahyo.csv;

import org.junit.jupiter.api.Test;
import org.yahyo.entity.Mouse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MouseParserTest {

    @Test
    void testReadData() {
        MouseParser parser = new MouseParser();
        List<Mouse> mice = parser.readData("src/main/resources/mouse.csv");

        assertNotNull(mice);
        assertEquals(7, mice.size());

        Mouse mouse1 = mice.get(0);
        assertEquals(1, mouse1.getId());
        assertEquals(30.0f, mouse1.getPrice());
        assertEquals("Logitech", mouse1.getBrand());
        assertEquals("Robust", mouse1.getDurability());
        assertEquals("USB", mouse1.getConnectivity());

        Mouse mouse2 = mice.get(1);
        assertEquals(2, mouse2.getId());
        assertEquals(50.0f, mouse2.getPrice());
        assertEquals("Razer", mouse2.getBrand());
        assertEquals("Sturdy", mouse2.getDurability());
        assertEquals("Bluetooth", mouse2.getConnectivity());

        Mouse mouse3 = mice.get(2);
        assertEquals(3, mouse3.getId());
        assertEquals(25.0f, mouse3.getPrice());
        assertEquals("Corsair", mouse3.getBrand());
        assertEquals("Durable", mouse3.getDurability());
        assertEquals("USB", mouse3.getConnectivity());

        Mouse mouse4 = mice.get(3);
        assertEquals(4, mouse4.getId());
        assertEquals(40.0f, mouse4.getPrice());
        assertEquals("SteelSeries", mouse4.getBrand());
        assertEquals("Resilient", mouse4.getDurability());
        assertEquals("Bluetooth", mouse4.getConnectivity());

        Mouse mouse5 = mice.get(4);
        assertEquals(5, mouse5.getId());
        assertEquals(35.0f, mouse5.getPrice());
        assertEquals("Microsoft", mouse5.getBrand());
        assertEquals("Strong", mouse5.getDurability());
        assertEquals("USB", mouse5.getConnectivity());

        Mouse mouse6 = mice.get(5);
        assertEquals(6, mouse6.getId());
        assertEquals(20.0f, mouse6.getPrice());
        assertEquals("Apple", mouse6.getBrand());
        assertEquals("Reliable", mouse6.getDurability());
        assertEquals("Bluetooth", mouse6.getConnectivity());

        Mouse mouse7 = mice.get(6);
        assertEquals(7, mouse7.getId());
        assertEquals(45.0f, mouse7.getPrice());
        assertEquals("HP", mouse7.getBrand());
        assertEquals("Tough", mouse7.getDurability());
        assertEquals("USB", mouse7.getConnectivity());
    }
}
