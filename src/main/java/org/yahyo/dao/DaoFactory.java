package org.yahyo.dao;

import org.yahyo.dao.item.KeyboardDao;
import org.yahyo.dao.item.MonitorDao;
import org.yahyo.dao.item.MouseDao;
import org.yahyo.entity.Computer;
import org.yahyo.entity.Keyboard;
import org.yahyo.entity.Monitor;
import org.yahyo.entity.Mouse;

public enum DaoFactory {
    INSTANCE;

    @SuppressWarnings("unchecked")
    public <A extends Computer> ComputerDao<A> getComputerDAO(Class<A> printedClass)  {
        if (Monitor.class.equals(printedClass)) {
            return (ComputerDao<A>) new MonitorDao();
        }
        if (Keyboard.class.equals(printedClass)) {
            return (ComputerDao<A>) new KeyboardDao();
        }
        if (Mouse.class.equals(printedClass)) {
            return (ComputerDao<A>) new MouseDao();
        }

        return null;
    }
}
