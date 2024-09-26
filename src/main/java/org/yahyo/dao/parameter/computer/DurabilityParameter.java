package org.yahyo.dao.parameter.computer;

import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Computer;

import java.security.InvalidParameterException;

public record DurabilityParameter<A extends Computer>(String durability) implements Parameter<A> {
    public DurabilityParameter {
        if (durability == null || durability.isBlank()) {
            throw new InvalidParameterException("Durability can't be empty");
        }
    }

    @Override
    public boolean test(A computer) {
        return durability.equalsIgnoreCase(computer.getDurability());
    }
}
