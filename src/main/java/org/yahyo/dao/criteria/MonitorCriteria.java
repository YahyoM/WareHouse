package org.yahyo.dao.criteria;


import org.yahyo.entity.Monitor;

public class MonitorCriteria  extends AbstractCriteria<Monitor> {
    @Override
    public Class<Monitor> getComputerType() {
        return Monitor.class;
    }
}
