package org.yahyo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yahyo.dao.criteria.MonitorCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.computer.IdParameter;
import org.yahyo.entity.Keyboard;
import org.yahyo.entity.Monitor;

import java.util.Collection;

public class MonitorServiceTest {

    @Test
    void testFindWithId() {
        MonitorService monitorService = new MonitorService();
        int id = 1;
        Collection<Monitor> monitors = monitorService.findWithId(id);
        Assertions.assertNotNull(monitors);
        Assertions.assertEquals(1, monitors.size());
        for (Monitor monitor : monitors) {
            Assertions.assertEquals(id, monitor.getId());
        }
    }

    @Test
    void testFindWithPrice() {
        KeyboardService keyboardService = new KeyboardService();
        float price = 100.0f;
        Collection<Keyboard> keyboards = keyboardService.findWithPrice(price);
        Assertions.assertNotNull(keyboards);
        Assertions.assertEquals(0, keyboards.size());
        for (Keyboard keyboard : keyboards) {
            Assertions.assertEquals(price, keyboard.getPrice());
        }
    }

    @Test
    void testFindWithBrand() {
        MonitorService monitorService = new MonitorService();
        String brand = "BrandXYZ";
        Collection<Monitor> monitors = monitorService.findWithBrand(brand);
        Assertions.assertNotNull(monitors);
        Assertions.assertTrue(monitors.isEmpty());
    }

    @Test
    void testFindAll() {
        MonitorService monitorService = new MonitorService();
        Collection<Monitor> monitors = monitorService.findAll();
        Assertions.assertNotNull(monitors);
        Assertions.assertFalse(monitors.isEmpty());
    }

    @Test
    void testFindWithCriteria() {
        MonitorService monitorService = new MonitorService();
        SearchCriteria<Monitor> criteria = new MonitorCriteria().add(new IdParameter<>(11));
        Collection<Monitor> monitors = monitorService.find(criteria);
        Assertions.assertNotNull(monitors);
        Assertions.assertTrue(monitors.isEmpty());
    }

    @Test
    void testFindWithResolution() {
        MonitorService monitorService = new MonitorService();
        String resolution = "FullHD";
        Collection<Monitor> monitors = monitorService.findWithResolution(resolution);
        Assertions.assertNotNull(monitors);
        Assertions.assertFalse(monitors.isEmpty());
        for (Monitor monitor : monitors) {
            Assertions.assertEquals(resolution, monitor.getResolution());
        }
    }
}
