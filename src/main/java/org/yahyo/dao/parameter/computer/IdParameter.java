package org.yahyo.dao.parameter.computer;

import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Computer;

import java.security.InvalidParameterException;

public record IdParameter<A extends Computer>(int id) implements Parameter<A> {
    public IdParameter {
        if (id < 0) {
            throw new InvalidParameterException("Id can't be less than 0");
        }
    }

    @Override
    public boolean test(Computer computer) {
        return computer.getId() == id;
    }
}
