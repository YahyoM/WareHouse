package org.yahyo.service;

import org.yahyo.dao.DaoFactory;
import org.yahyo.dao.criteria.MonitorCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.ResolutionParameter;
import org.yahyo.dao.parameter.computer.BrandParameter;
import org.yahyo.dao.parameter.computer.DurabilityParameter;
import org.yahyo.dao.parameter.computer.IdParameter;
import org.yahyo.dao.parameter.computer.PriceParameter;
import org.yahyo.entity.Monitor;

import java.util.Collection;

public class MonitorService implements MainService<Monitor> {
    @Override
    public Collection<Monitor> find(SearchCriteria<Monitor> criteria) {
        return DaoFactory.INSTANCE.getComputerDAO(criteria.getComputerType()).find(criteria);
    }

    @Override
    public Collection<Monitor> findAll() {
        return DaoFactory.INSTANCE.getComputerDAO(Monitor.class).findAll(new MonitorCriteria());
    }

    @Override
    public Collection<Monitor> findWithId(int id) {
        return DaoFactory.INSTANCE.getComputerDAO(Monitor.class).find(new MonitorCriteria().add(new IdParameter<>(id)));
    }

    @Override
    public Collection<Monitor> findWithPrice(float price) {
        return DaoFactory.INSTANCE.getComputerDAO(Monitor.class).find(new MonitorCriteria().add(new PriceParameter<>(price)));
    }

    @Override
    public Collection<Monitor> findWithBrand(String brand) {
        return DaoFactory.INSTANCE.getComputerDAO(Monitor.class).find(new MonitorCriteria().add(new BrandParameter<>(brand)));
    }

    @Override
    public Collection<Monitor> findWithDurability(String durability) {
        return DaoFactory.INSTANCE.getComputerDAO(Monitor.class).find(new MonitorCriteria().add(new DurabilityParameter<>(durability)));
    }

    @Override
    public Collection<Monitor> findWithResolution(String resolution) {
        return DaoFactory.INSTANCE.getComputerDAO(Monitor.class).find(new MonitorCriteria().add(new ResolutionParameter<>(resolution)));
    }
}
