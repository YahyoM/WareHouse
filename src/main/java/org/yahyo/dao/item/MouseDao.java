package org.yahyo.dao.item;

import org.yahyo.csv.MouseParser;
import org.yahyo.dao.AbstractDAO;
import org.yahyo.entity.Mouse;

public class MouseDao extends AbstractDAO<Mouse> {
    public MouseDao(){
        super("src/main/resources/mouse.csv", new MouseParser());
    }
}
