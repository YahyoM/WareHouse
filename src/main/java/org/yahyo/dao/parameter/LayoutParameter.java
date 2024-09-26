package org.yahyo.dao.parameter;

import org.yahyo.entity.Keyboard;

import java.security.InvalidParameterException;

public record LayoutParameter<A extends Keyboard>(String layout) implements Parameter<A> {
    public LayoutParameter {
        if (layout == null || layout.isBlank()) {
            throw new InvalidParameterException("Layout can't be empty");
        }
    }

    @Override
    public boolean test(A keyboard) {
        return layout.equalsIgnoreCase(keyboard.getLayout());
    }
}
