package com.ecobike.dao;

import java.util.List;

public interface GenericDao<T> {
    T add(T t);

    List<T> getAll();
}
