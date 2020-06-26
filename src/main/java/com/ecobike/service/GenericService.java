package com.ecobike.service;

import java.util.List;

public interface GenericService<T> {
    T add(T t);

    List<T> getAll();

    T buildEntityFromString(String s);

    String buildStringFromEntity(T t);
}
