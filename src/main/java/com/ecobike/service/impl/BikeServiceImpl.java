package com.ecobike.service.impl;

import com.ecobike.annotation.Service;
import com.ecobike.model.Bike;
import com.ecobike.service.BikeService;
import java.util.List;
import java.util.function.Predicate;

@Service
public class BikeServiceImpl implements BikeService {
    @Override
    public List<Bike> getAll() {
        return null;
    }

    @Override
    public List<Bike> get(Predicate predicate) {
        return null;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
