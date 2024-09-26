package org.yahyo.dao.parameter.computer;

import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Computer;

import java.security.InvalidParameterException;

public record PriceParameter<A extends Computer>(float price) implements Parameter<A> {
    public PriceParameter {
        if (price < 0) {
            throw new InvalidParameterException("Price can't be less than 0");
        }
    }

    @Override
    public boolean test(Computer computer) {
        return computer.getPrice() == price;
    }
}
