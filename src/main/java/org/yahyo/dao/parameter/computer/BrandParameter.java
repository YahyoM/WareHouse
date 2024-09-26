package org.yahyo.dao.parameter.computer;

import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Computer;

import java.security.InvalidParameterException;

public record BrandParameter<A extends Computer>(String brand) implements Parameter<A> {
    public BrandParameter {
        if (brand == null || brand.isBlank()) {
            throw new InvalidParameterException("Brand can't be empty");
        }
    }

    @Override
    public boolean test(A computer) {
        return computer.getBrand().equalsIgnoreCase(brand);
    }
}
