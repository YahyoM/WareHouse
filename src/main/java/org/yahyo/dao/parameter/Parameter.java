package org.yahyo.dao.parameter;

import org.yahyo.entity.Computer;

public interface Parameter<A extends Computer> {
    boolean test(A computer);
}
