package org.yahyo.dao.criteria;


import org.yahyo.entity.Mouse;

public class MouseCriteria  extends AbstractCriteria<Mouse> {
    @Override
    public Class<Mouse> getComputerType() {
        return Mouse.class;
    }
}
