package org.yahyo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yahyo.dao.criteria.KeyboardCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.computer.IdParameter;
import org.yahyo.entity.Keyboard;

import java.util.Collection;

public class KeyboardServiceTest {

    @Test
    void testFindWithId() {
        KeyboardService keyboardService = new KeyboardService();
        int id = 1;
        Collection<Keyboard> keyboards = keyboardService.findWithId(id);
        Assertions.assertNotNull(keyboards);
        Assertions.assertEquals(1, keyboards.size());
        for (Keyboard keyboard : keyboards) {
            Assertions.assertEquals(id, keyboard.getId());
        }
    }

    @Test
    void testFindWithPrice() {
        KeyboardService keyboardService = new KeyboardService();
        float price = 100.0f;
        Collection<Keyboard> keyboards = keyboardService.findWithPrice(price);
        Assertions.assertNotNull(keyboards);
        Assertions.assertTrue(keyboards.isEmpty());
    }

    @Test
    void testFindWithBrand() {
        KeyboardService keyboardService = new KeyboardService();
        String brand = "BrandXYZ";
        Collection<Keyboard> keyboards = keyboardService.findWithBrand(brand);
        Assertions.assertNotNull(keyboards);
        Assertions.assertTrue(keyboards.isEmpty());
    }

    @Test
    void testFindAll() {
        KeyboardService keyboardService = new KeyboardService();
        Collection<Keyboard> keyboards = keyboardService.findAll();
        Assertions.assertNotNull(keyboards);
        Assertions.assertFalse(keyboards.isEmpty());
    }

    @Test
    void testFindWithCriteria() {
        KeyboardService keyboardService = new KeyboardService();
        SearchCriteria<Keyboard> criteria = new KeyboardCriteria().add(new IdParameter<>(11));
        Collection<Keyboard> keyboards = keyboardService.find(criteria);
        Assertions.assertNotNull(keyboards);
        Assertions.assertTrue(keyboards.isEmpty());
    }

    @Test
    void testFindWithLayout() {
        KeyboardService keyboardService = new KeyboardService();
        String layout = "QWERTY";
        Collection<Keyboard> keyboards = keyboardService.findWithLayout(layout);
        Assertions.assertNotNull(keyboards);
        Assertions.assertFalse(keyboards.isEmpty());
        for (Keyboard keyboard : keyboards) {
            Assertions.assertEquals(layout, keyboard.getLayout());
        }
    }
}
