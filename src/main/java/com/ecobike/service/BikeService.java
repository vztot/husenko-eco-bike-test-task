package com.ecobike.service;

import com.ecobike.model.Bike;
import java.util.List;
import java.util.function.Predicate;

public interface BikeService {
    List<Bike> getAll();

    List<Bike> get(Predicate predicate);

    String sayHello();
}
