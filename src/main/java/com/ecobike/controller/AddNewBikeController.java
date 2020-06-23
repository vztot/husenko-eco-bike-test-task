package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AddNewBikeController {
    private static final Map<String, Command> COMMAND_MAP;
    private String bikeType;

    public AddNewBikeController(String bikeType) {
        COMMAND_MAP.get(bikeType);
    }

    static {
        Map<String, Command> map = new HashMap<>();
        map.put("FOLDING BIKE", () -> {

        });
        map.put("SPEEDELEC", () -> {

        });
        map.put("E-BIKE", () -> {

        });
        COMMAND_MAP = Collections.unmodifiableMap(map);
    }

    private interface Command {
        void execute();
    }
}
