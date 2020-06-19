package com.ecobike.context;

import com.ecobike.service.BikeService;
import com.ecobike.util.Injector;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    // This is a simple implementation of a context provider made like command pattern

    private static final Map<String, Object> SERVICES;
    private static final Injector INJECTOR = Injector.getInstance("com.ecobike");
    private static BikeService bikeService = (BikeService) INJECTOR.getInstance(BikeService.class);

    static {
        final Map<String, Object> services = new HashMap<>();
        services.put("BikeService", bikeService);
        SERVICES = Collections.unmodifiableMap(services);
    }

    public Object getServiceByName(String serviceName) {
        Object service = SERVICES.get(serviceName);
        if (service == null) {
            throw new RuntimeException("Cant get service: " + serviceName);
        }
        return service;
    }
}
