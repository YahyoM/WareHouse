package org.yahyo.dao;

import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.entity.Computer;

import java.util.List;

public interface ComputerDao<A extends Computer> {
    List<A> find(SearchCriteria<A> criteria);
    List<A> findAll(SearchCriteria<A> criteria);
}
