package org.yahyo.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KeyboardTest {

    @Test
    void testKeyboardCreation() {
        Keyboard keyboard = new Keyboard(1, 50, "Logitech", "Robust", "QWERTY");
        assertNotNull(keyboard);
        assertEquals(1, keyboard.getId());
        assertEquals(50, keyboard.getPrice(), 0.01);
        assertEquals("Logitech", keyboard.getBrand());
        assertEquals("Robust", keyboard.getDurability());
        assertEquals("QWERTY", keyboard.getLayout());
    }

    @Test
    void testKeyboardEqualityAndHashcode() {
        Keyboard keyboard1 = new Keyboard(2, 80, "Razer", "Sturdy", "QWERTZ");
        Keyboard keyboard2 = new Keyboard(2, 80, "Razer", "Sturdy", "QWERTZ");
        Keyboard keyboard3 = new Keyboard(3, 40, "Corsair", "Durable", "AZERTY");

        assertEquals(keyboard1, keyboard2);
        assertNotEquals(keyboard1, keyboard3);
        assertEquals(keyboard1.hashCode(), keyboard2.hashCode());
        assertNotEquals(keyboard1.hashCode(), keyboard3.hashCode());
    }

    @Test
    void testKeyboardToString() {
        Keyboard keyboard = new Keyboard(4, 60, "SteelSeries", "Resilient", "QWERTY");
        String expected = "Keyboard{id=4, price=60.0, brand='SteelSeries', durability='Resilient', layout='QWERTY'}";
        assertEquals(expected, keyboard.toString());
    }
}
