package org.yahyo.service;

import org.yahyo.dao.DaoFactory;
import org.yahyo.dao.criteria.MouseCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.ConnectivityParameter;
import org.yahyo.dao.parameter.computer.BrandParameter;
import org.yahyo.dao.parameter.computer.DurabilityParameter;
import org.yahyo.dao.parameter.computer.IdParameter;
import org.yahyo.dao.parameter.computer.PriceParameter;
import org.yahyo.entity.Mouse;

import java.util.Collection;

public class MouseService implements MainService<Mouse>{
    @Override
    public Collection<Mouse> find(SearchCriteria<Mouse> criteria) {
        return DaoFactory.INSTANCE.getComputerDAO(criteria.getComputerType()).find(criteria);
    }

    @Override
    public Collection<Mouse> findAll() {
        return DaoFactory.INSTANCE.getComputerDAO(Mouse.class).findAll(new MouseCriteria());
    }

    @Override
    public Collection<Mouse> findWithId(int id) {
        return DaoFactory.INSTANCE.getComputerDAO(Mouse.class).find(new MouseCriteria().add(new IdParameter<>(id)));
    }

    @Override
    public Collection<Mouse> findWithPrice(float price) {
        return DaoFactory.INSTANCE.getComputerDAO(Mouse.class).find(new MouseCriteria().add(new PriceParameter<>(price)));
    }

    @Override
    public Collection<Mouse> findWithBrand(String brand) {
        return DaoFactory.INSTANCE.getComputerDAO(Mouse.class).find(new MouseCriteria().add(new BrandParameter<>(brand)));
    }

    @Override
    public Collection<Mouse> findWithDurability(String durability) {
        return DaoFactory.INSTANCE.getComputerDAO(Mouse.class).find(new MouseCriteria().add(new DurabilityParameter<>(durability)));
    }

    @Override
    public Collection<Mouse> findWithConnectivity(String connectivity) {
        return DaoFactory.INSTANCE.getComputerDAO(Mouse.class).find(new MouseCriteria().add(new ConnectivityParameter<>(connectivity)));
    }
}
