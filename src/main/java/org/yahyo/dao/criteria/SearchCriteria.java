package org.yahyo.dao.criteria;

import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Computer;

public interface SearchCriteria<A extends Computer> {
    Class<A> getComputerType();
    <P extends Parameter<A>> SearchCriteria<A> add(P parameter);
    boolean test(A printed);
}
