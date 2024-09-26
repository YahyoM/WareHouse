package org.yahyo.service;

import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.entity.Computer;

import java.util.ArrayList;
import java.util.Collection;

public interface MainService<A extends Computer> {
    Collection<A> find(SearchCriteria<A> criteria);

    Collection<A> findAll();

    Collection<A> findWithId(int id);

    Collection<A> findWithPrice(float price);

    Collection<A> findWithBrand(String brand);

    Collection<A> findWithDurability(String durability);

    default Collection<A> findWithResolution(String resolution){return new ArrayList<>();}

    default Collection<A> findWithLayout(String resolution){return new ArrayList<>();};

    default Collection<A> findWithConnectivity(String connectivity){return new ArrayList<>();};
}
