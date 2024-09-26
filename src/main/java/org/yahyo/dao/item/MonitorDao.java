package org.yahyo.dao.item;

import org.yahyo.csv.MonitorParser;
import org.yahyo.dao.AbstractDAO;
import org.yahyo.entity.Monitor;

public class MonitorDao extends AbstractDAO<Monitor> {
    public MonitorDao(){
        super("src/main/resources/monitor.csv", new MonitorParser());
    }
}