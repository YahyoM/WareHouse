package org.yahyo.dao.criteria;

import org.yahyo.dao.parameter.Parameter;
import org.yahyo.entity.Computer;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCriteria<A extends Computer>
        implements SearchCriteria<A> {

    protected final Map<Class<?>, Parameter<A>> parameters = new HashMap<>();

    @Override
    public <F extends Parameter<A>> SearchCriteria<A> add(F parameter) {
        parameters.put(parameter.getClass(), parameter);
        return this;
    }

    @Override
    public boolean test(A computer) {
        return parameters.values().stream().allMatch(item-> item.test(computer)) ;
    }
}
