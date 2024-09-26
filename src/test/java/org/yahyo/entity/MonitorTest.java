package org.yahyo.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonitorTest {

    @Test
    void testMonitorCreation() {
        Monitor monitor = new Monitor(1, 250, "Samsung", "Robust", "FullHD");
        assertNotNull(monitor);
        assertEquals(1, monitor.getId());
        assertEquals(250, monitor.getPrice(), 0.01);
        assertEquals("Samsung", monitor.getBrand());
        assertEquals("Robust", monitor.getDurability());
        assertEquals("FullHD", monitor.getResolution());
    }

    @Test
    void testMonitorEqualityAndHashcode() {
        Monitor monitor1 = new Monitor(2, 450, "LG", "Sturdy", "4K");
        Monitor monitor2 = new Monitor(2, 450, "LG", "Sturdy", "4K");
        Monitor monitor3 = new Monitor(3, 180, "Dell", "Durable", "HD");

        assertEquals(monitor1, monitor2);
        assertNotEquals(monitor1, monitor3);
        assertEquals(monitor1.hashCode(), monitor2.hashCode());
        assertNotEquals(monitor1.hashCode(), monitor3.hashCode());
    }

    @Test
    void testMonitorToString() {
        Monitor monitor = new Monitor(4, 300, "HP", "Resilient", "QHD");
        String expected = "Monitor{id=4, price=300.0, brand='HP', durability='Resilient', resolution='QHD'}";
        assertEquals(expected, monitor.toString());
    }
}
