package org.yahyo.dao.criteria;


import org.yahyo.entity.Keyboard;

public class KeyboardCriteria  extends AbstractCriteria<Keyboard> {
    @Override
    public Class<Keyboard> getComputerType() {
        return Keyboard.class;
    }
}