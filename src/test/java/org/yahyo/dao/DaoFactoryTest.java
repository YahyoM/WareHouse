package org.yahyo.dao;

import org.junit.jupiter.api.Test;
import org.yahyo.dao.item.KeyboardDao;
import org.yahyo.dao.item.MonitorDao;
import org.yahyo.dao.item.MouseDao;
import org.yahyo.entity.Keyboard;
import org.yahyo.entity.Monitor;
import org.yahyo.entity.Mouse;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class DaoFactoryTest {

    @Test
    public void testGetComputerDAO_Monitor() {
        DaoFactory factory = DaoFactory.INSTANCE;
        ComputerDao<Monitor> monitorDao = factory.getComputerDAO(Monitor.class);
        assertInstanceOf(MonitorDao.class, monitorDao);
    }

    @Test
    public void testGetComputerDAO_Keyboard() {
        DaoFactory factory = DaoFactory.INSTANCE;
        ComputerDao<Keyboard> keyboardDao = factory.getComputerDAO(Keyboard.class);
        assertInstanceOf(KeyboardDao.class, keyboardDao);
    }

    @Test
    public void testGetComputerDAO_Mouse() {
        DaoFactory factory = DaoFactory.INSTANCE;
        ComputerDao<Mouse> mouseDao = factory.getComputerDAO(Mouse.class);
        assertInstanceOf(MouseDao.class, mouseDao);
    }
}
