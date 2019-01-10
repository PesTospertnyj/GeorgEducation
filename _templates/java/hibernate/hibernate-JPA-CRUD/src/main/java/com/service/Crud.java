package com.service;

import java.util.List;

public interface Crud<T> {

    T create(T t);
    T read(Object obj);
    T update(T t);
    void remove(T t);
    List<T> getAll();

}
