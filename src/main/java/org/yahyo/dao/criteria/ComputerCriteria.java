package org.yahyo.dao.criteria;


import org.yahyo.entity.Computer;

public class ComputerCriteria  extends AbstractCriteria<Computer> {
    @Override
    public Class<Computer> getComputerType() {
        return Computer.class;
    }
}