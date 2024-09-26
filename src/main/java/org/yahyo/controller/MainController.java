package org.yahyo.controller;

import org.yahyo.entity.Computer;

import java.util.Collection;

public interface MainController<A extends Computer> {
    Collection<A> run();
}
