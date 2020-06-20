package com.ecobike.context;

import com.ecobike.util.Injector;
import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    // custom Application context aka singleton

    private static ApplicationContext ctx;

    private Injector injector;
    private Map<String, Object> services;

    private ApplicationContext() {
        injector = Injector.getInstance("com.ecobike");
        this.services = new HashMap<>();
    }

    public Object getService(Class clazz) {
        Object service = services.get(clazz.getName());
        if (service == null) {
            try {
                service = injector.getInstance(clazz);
                services.put(clazz.getName(), service);
            } catch (Exception e) {
                throw new RuntimeException("Cant get service: " + clazz.getName());
            }
        }
        return service;
    }

    public static ApplicationContext getInstance() {
        if (ctx == null) {
            ctx = new ApplicationContext();
        }
        return ctx;
    }
}
