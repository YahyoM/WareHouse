package org.yahyo.dao.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yahyo.dao.criteria.MouseCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Mouse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class MouseDaoTest {
    private MouseDao mouseDao;

    @BeforeEach
    void setUp() {
        mouseDao = new MouseDao();
    }

    @Test
    void shouldFindAllMice() {
        SearchCriteria<Mouse> criteria = new MouseCriteria().add(MouseParameterExtTest.any());
        Iterable<Mouse> iterable = mouseDao.find(criteria);

        assertNotNull(iterable);
        Mouse[] mice = toArray(iterable, Mouse[]::new);
        assertTrue(mice.length > 0, "Expected non-zero number of mice");
    }

    @Test
    void shouldFindNoMice() {
        SearchCriteria<Mouse> criteria = new MouseCriteria().add(MouseParameterExtTest.none());
        Iterable<Mouse> iterable = mouseDao.find(criteria);

        assertNotNull(iterable);
        Mouse[] mice = toArray(iterable, Mouse[]::new);
        assertEquals(0, mice.length, "Expected zero mice");
    }

    private <A extends Mouse> A[] toArray(Iterable<A> iterable, IntFunction<A[]> generator) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] array = list.toArray(generator);
        Arrays.sort(array, Comparator.comparingDouble(Mouse::getPrice));
        return array;
    }

    interface MouseParameterExtTest extends Parameter<Mouse> {
        static Parameter<Mouse> any() {
            return mouse -> true;
        }

        static Parameter<Mouse> none() {
            return mouse -> false;
        }
    }
}
