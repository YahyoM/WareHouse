package org.yahyo.dao.parameter;

import org.yahyo.entity.Mouse;

import java.security.InvalidParameterException;

public record ConnectivityParameter<A extends Mouse>(String connectivity) implements Parameter<A> {
    public ConnectivityParameter {
        if (connectivity == null || connectivity.isBlank()) {
            throw new InvalidParameterException("Connectivity can't be empty");
        }
    }

    @Override
    public boolean test(A mouse) {
        return connectivity.equalsIgnoreCase(mouse.getConnectivity());
    }
}
