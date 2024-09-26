package org.yahyo.dao.parameter;

import org.yahyo.entity.Monitor;

import java.security.InvalidParameterException;

public record ResolutionParameter<A extends Monitor>(String resolution) implements Parameter<A> {
    public ResolutionParameter {
        if (resolution == null || resolution.isBlank()) {
            throw new InvalidParameterException("Resolution can't be empty");
        }
    }

    @Override
    public boolean test(A monitor) {
        return resolution.equalsIgnoreCase(monitor.getResolution());
    }
}
