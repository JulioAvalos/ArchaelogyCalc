package com.arch.calculator.services;

import java.util.List;

public interface BaseCrud<T> {
    List<T> listAll();

    T add(T obj);

    T modify(T obj);

    T getById(Long id);

    boolean remove(Long id);
}
