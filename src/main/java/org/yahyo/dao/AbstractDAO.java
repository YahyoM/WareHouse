package org.yahyo.dao;

import org.yahyo.csv.CsvLineParser;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.entity.Computer;

import java.util.List;

public abstract class AbstractDAO<A extends Computer> implements ComputerDao<A> {
    private final String csvPath;
    private final CsvLineParser<A> parser;

    protected AbstractDAO(String path, CsvLineParser<A> parser) {
        if (path == null || parser == null) {
            throw new IllegalArgumentException("CSV path and parser must be provided.");
        }
        this.csvPath = path;
        this.parser = parser;
    }

    @Override
    public List<A> findAll(SearchCriteria<A> criteria) {
        List<A> data = parser.readData(csvPath);
        return filterData(data, criteria);
    }

    @Override
    public List<A> find(SearchCriteria<A> criteria) {
        return findAll(criteria);
    }

    private List<A> filterData(List<A> data, SearchCriteria<A> criteria) {
        if (criteria == null) {
            return data;
        }
        return data.stream().filter(criteria::test).toList();
    }
}
