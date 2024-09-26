package org.yahyo.dao.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yahyo.dao.criteria.KeyboardCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class KeyboardDaoTest {
    private KeyboardDao keyboardDao;

    @BeforeEach
    void setUp() {
        keyboardDao = new KeyboardDao();
    }

    @Test
    void shouldFindAllKeyboards() {
        SearchCriteria<Keyboard> criteria = new KeyboardCriteria().add(KeyboardParameterExtTest.any());
        Iterable<Keyboard> iterable = keyboardDao.find(criteria);

        assertNotNull(iterable);
        Keyboard[] keyboards = toArray(iterable, Keyboard[]::new);
        assertTrue(keyboards.length > 0, "Expected non-zero number of keyboards");
    }

    @Test
    void shouldFindNoKeyboards() {
        SearchCriteria<Keyboard> criteria = new KeyboardCriteria().add(KeyboardParameterExtTest.none());
        Iterable<Keyboard> iterable = keyboardDao.find(criteria);

        assertNotNull(iterable);
        Keyboard[] keyboards = toArray(iterable, Keyboard[]::new);
        assertEquals(0, keyboards.length, "Expected zero keyboards");
    }

    private <A extends Keyboard> A[] toArray(Iterable<A> iterable, IntFunction<A[]> generator) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] array = list.toArray(generator);
        Arrays.sort(array, Comparator.comparingDouble(Keyboard::getPrice));
        return array;
    }

    interface KeyboardParameterExtTest extends Parameter<Keyboard> {
        static Parameter<Keyboard> any() {
            return keyboard -> true;
        }

        static Parameter<Keyboard> none() {
            return keyboard -> false;
        }
    }
}
