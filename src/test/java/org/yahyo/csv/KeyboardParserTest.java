package org.yahyo.csv;

import org.junit.jupiter.api.Test;
import org.yahyo.entity.Keyboard;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardParserTest {

    @Test
    void testReadData() {
        KeyboardParser parser = new KeyboardParser();
        List<Keyboard> keyboards = parser.readData("src/main/resources/keyboard.csv");

        assertNotNull(keyboards);
        assertEquals(7, keyboards.size());

        Keyboard keyboard1 = keyboards.get(0);
        assertEquals(1, keyboard1.getId());
        assertEquals(50.0f, keyboard1.getPrice());
        assertEquals("Logitech", keyboard1.getBrand());
        assertEquals("Robust", keyboard1.getDurability());
        assertEquals("QWERTY", keyboard1.getLayout());

        Keyboard keyboard2 = keyboards.get(1);
        assertEquals(2, keyboard2.getId());
        assertEquals(80.0f, keyboard2.getPrice());
        assertEquals("Razer", keyboard2.getBrand());
        assertEquals("Sturdy", keyboard2.getDurability());
        assertEquals("QWERTZ", keyboard2.getLayout());

        Keyboard keyboard3 = keyboards.get(2);
        assertEquals(3, keyboard3.getId());
        assertEquals(40.0f, keyboard3.getPrice());
        assertEquals("Corsair", keyboard3.getBrand());
        assertEquals("Durable", keyboard3.getDurability());
        assertEquals("AZERTY", keyboard3.getLayout());

        Keyboard keyboard4 = keyboards.get(3);
        assertEquals(4, keyboard4.getId());
        assertEquals(60.0f, keyboard4.getPrice());
        assertEquals("SteelSeries", keyboard4.getBrand());
        assertEquals("Resilient", keyboard4.getDurability());
        assertEquals("QWERTY", keyboard4.getLayout());

        Keyboard keyboard5 = keyboards.get(4);
        assertEquals(5, keyboard5.getId());
        assertEquals(70.0f, keyboard5.getPrice());
        assertEquals("Microsoft", keyboard5.getBrand());
        assertEquals("Strong", keyboard5.getDurability());
        assertEquals("QWERTY", keyboard5.getLayout());

        Keyboard keyboard6 = keyboards.get(5);
        assertEquals(6, keyboard6.getId());
        assertEquals(55.0f, keyboard6.getPrice());
        assertEquals("Apple", keyboard6.getBrand());
        assertEquals("Reliable", keyboard6.getDurability());
        assertEquals("QWERTY", keyboard6.getLayout());

        Keyboard keyboard7 = keyboards.get(6);
        assertEquals(7, keyboard7.getId());
        assertEquals(90.0f, keyboard7.getPrice());
        assertEquals("Cooler Master", keyboard7.getBrand());
        assertEquals("Tough", keyboard7.getDurability());
        assertEquals("QWERTY", keyboard7.getLayout());
    }
}
