package org.yahyo.dao.item;

import org.yahyo.csv.KeyboardParser;
import org.yahyo.dao.AbstractDAO;
import org.yahyo.entity.Keyboard;

public class KeyboardDao extends AbstractDAO<Keyboard> {
    public KeyboardDao(){
        super("src/main/resources/keyboard.csv", new KeyboardParser());
    }
}
