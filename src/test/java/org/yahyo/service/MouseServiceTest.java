package org.yahyo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yahyo.dao.criteria.MouseCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.computer.IdParameter;
import org.yahyo.entity.Keyboard;
import org.yahyo.entity.Mouse;

import java.util.Collection;

public class MouseServiceTest {

    @Test
    void testFindWithId() {
        MouseService mouseService = new MouseService();
        int id = 1;
        Collection<Mouse> mice = mouseService.findWithId(id);
        Assertions.assertNotNull(mice);
        Assertions.assertEquals(1, mice.size());
        for (Mouse mouse : mice) {
            Assertions.assertEquals(id, mouse.getId());
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
        MouseService mouseService = new MouseService();
        String brand = "BrandXYZ";
        Collection<Mouse> mice = mouseService.findWithBrand(brand);
        Assertions.assertNotNull(mice);
        Assertions.assertTrue(mice.isEmpty());
    }

    @Test
    void testFindAll() {
        MouseService mouseService = new MouseService();
        Collection<Mouse> mice = mouseService.findAll();
        Assertions.assertNotNull(mice);
        Assertions.assertFalse(mice.isEmpty());
    }

    @Test
    void testFindWithCriteria() {
        MouseService mouseService = new MouseService();
        SearchCriteria<Mouse> criteria = new MouseCriteria().add(new IdParameter<>(11));
        Collection<Mouse> mice = mouseService.find(criteria);
        Assertions.assertNotNull(mice);
        Assertions.assertTrue(mice.isEmpty());
    }

    @Test
    void testFindWithConnectivity() {
        MouseService mouseService = new MouseService();
        String connectivity = "USB";
        Collection<Mouse> mice = mouseService.findWithConnectivity(connectivity);
        Assertions.assertNotNull(mice);
        Assertions.assertFalse(mice.isEmpty());
        for (Mouse mouse : mice) {
            Assertions.assertEquals(connectivity, mouse.getConnectivity());
        }
    }
}
