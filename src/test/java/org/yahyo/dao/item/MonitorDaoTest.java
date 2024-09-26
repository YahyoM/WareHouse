package org.yahyo.dao.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yahyo.dao.criteria.MonitorCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Monitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

import static org.junit.jupiter.api.Assertions.*;

class MonitorDaoTest {
    private MonitorDao monitorDao;

    @BeforeEach
    void setUp() {
        monitorDao = new MonitorDao();
    }

    @Test
    void shouldFindAllMonitors() {
        SearchCriteria<Monitor> criteria = new MonitorCriteria().add(MonitorParameterExtTest.any());
        Iterable<Monitor> iterable = monitorDao.find(criteria);

        assertNotNull(iterable);
        Monitor[] monitors = toArray(iterable, Monitor[]::new);
        assertTrue(monitors.length > 0, "Expected non-zero number of monitors");
    }

    @Test
    void shouldFindNoMonitors() {
        SearchCriteria<Monitor> criteria = new MonitorCriteria().add(MonitorParameterExtTest.none());
        Iterable<Monitor> iterable = monitorDao.find(criteria);

        assertNotNull(iterable);
        Monitor[] monitors = toArray(iterable, Monitor[]::new);
        assertEquals(0, monitors.length, "Expected zero monitors");
    }

    private <A extends Monitor> A[] toArray(Iterable<A> iterable, IntFunction<A[]> generator) {
        ArrayList<A> list = new ArrayList<>();
        iterable.forEach(list::add);
        A[] array = list.toArray(generator);
        Arrays.sort(array, Comparator.comparingDouble(Monitor::getPrice));
        return array;
    }

    interface MonitorParameterExtTest extends Parameter<Monitor> {
        static Parameter<Monitor> any() {
            return monitor -> true;
        }

        static Parameter<Monitor> none() {
            return monitor -> false;
        }
    }
}
