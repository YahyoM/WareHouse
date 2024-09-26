package org.yahyo.csv;

import org.junit.jupiter.api.Test;
import org.yahyo.entity.Monitor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MonitorParserTest {

    @Test
    void testReadData() {
        MonitorParser parser = new MonitorParser();
        List<Monitor> monitors = parser.readData("src/main/resources/monitor.csv");

        assertNotNull(monitors);
        assertEquals(7, monitors.size());

        Monitor monitor1 = monitors.get(0);
        assertEquals(1, monitor1.getId());
        assertEquals(250.0f, monitor1.getPrice());
        assertEquals("Samsung", monitor1.getBrand());
        assertEquals("Robust", monitor1.getDurability());
        assertEquals("FullHD", monitor1.getResolution());

        Monitor monitor2 = monitors.get(1);
        assertEquals(2, monitor2.getId());
        assertEquals(450.0f, monitor2.getPrice());
        assertEquals("LG", monitor2.getBrand());
        assertEquals("Sturdy", monitor2.getDurability());
        assertEquals("4K", monitor2.getResolution());

        Monitor monitor3 = monitors.get(2);
        assertEquals(3, monitor3.getId());
        assertEquals(180.0f, monitor3.getPrice());
        assertEquals("Dell", monitor3.getBrand());
        assertEquals("Durable", monitor3.getDurability());
        assertEquals("HD", monitor3.getResolution());

        Monitor monitor4 = monitors.get(3);
        assertEquals(4, monitor4.getId());
        assertEquals(300.0f, monitor4.getPrice());
        assertEquals("HP", monitor4.getBrand());
        assertEquals("Resilient", monitor4.getDurability());
        assertEquals("QHD", monitor4.getResolution());

        Monitor monitor5 = monitors.get(4);
        assertEquals(5, monitor5.getId());
        assertEquals(350.0f, monitor5.getPrice());
        assertEquals("Acer", monitor5.getBrand());
        assertEquals("Strong", monitor5.getDurability());
        assertEquals("UltraWide", monitor5.getResolution());

        Monitor monitor6 = monitors.get(5);
        assertEquals(6, monitor6.getId());
        assertEquals(200.0f, monitor6.getPrice());
        assertEquals("ASUS", monitor6.getBrand());
        assertEquals("Reliable", monitor6.getDurability());
        assertEquals("FullHD", monitor6.getResolution());

        Monitor monitor7 = monitors.get(6);
        assertEquals(7, monitor7.getId());
        assertEquals(400.0f, monitor7.getPrice());
        assertEquals("BenQ", monitor7.getBrand());
        assertEquals("Tough", monitor7.getDurability());
        assertEquals("4K", monitor7.getResolution());
    }
}
