package org.yahyo.service;

import org.yahyo.dao.DaoFactory;
import org.yahyo.dao.criteria.KeyboardCriteria;
import org.yahyo.dao.criteria.SearchCriteria;
import org.yahyo.dao.parameter.LayoutParameter;
import org.yahyo.dao.parameter.computer.BrandParameter;
import org.yahyo.dao.parameter.computer.DurabilityParameter;
import org.yahyo.dao.parameter.computer.IdParameter;
import org.yahyo.dao.parameter.computer.PriceParameter;
import org.yahyo.entity.Keyboard;

import java.util.Collection;

public class KeyboardService implements MainService<Keyboard> {
    @Override
    public Collection<Keyboard> find(SearchCriteria<Keyboard> criteria) {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).find(criteria);
    }

    @Override
    public Collection<Keyboard> findAll() {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).findAll(new KeyboardCriteria());
    }

    @Override
    public Collection<Keyboard> findWithId(int id) {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).find(new KeyboardCriteria().add(new IdParameter<>(id)));
    }

    @Override
    public Collection<Keyboard> findWithPrice(float price) {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).find(new KeyboardCriteria().add(new PriceParameter<>(price)));
    }

    @Override
    public Collection<Keyboard> findWithBrand(String brand) {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).find(new KeyboardCriteria().add(new BrandParameter<>(brand)));
    }

    @Override
    public Collection<Keyboard> findWithDurability(String durability) {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).find(new KeyboardCriteria().add(new DurabilityParameter<>(durability)));
    }

    @Override
    public Collection<Keyboard> findWithLayout(String layout) {
        return DaoFactory.INSTANCE.getComputerDAO(Keyboard.class).find(new KeyboardCriteria().add(new LayoutParameter<>(layout)));
    }
}
