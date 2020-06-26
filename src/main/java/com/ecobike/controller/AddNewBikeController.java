package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.context.AppContext;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.service.EbikeService;
import com.ecobike.service.FoldingBikeService;
import com.ecobike.service.SpeedelecService;
import com.ecobike.util.ValidateUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class AddNewBikeController {
    private static final Map<String, Command> COMMAND_MAP;

    private static FoldingBikeService foldingBikeService =
            (FoldingBikeService) AppContext.getInstance().getService(FoldingBikeService.class);
    private static EbikeService ebikeService =
            (EbikeService) AppContext.getInstance().getService(EbikeService.class);
    private static SpeedelecService speedelecService =
            (SpeedelecService) AppContext.getInstance().getService(SpeedelecService.class);

    public AddNewBikeController(String bikeType, List<String> newLines) {
        COMMAND_MAP.get(bikeType).execute();
    }

    static {
        Map<String, Command> map = new HashMap<>();
        map.put("FOLDING BIKE", () -> {
            FoldingBike foldingBike = buildFoldingBikeFromUserInput();
            if (foldingBike != null) {
                String entityString = foldingBikeService.buildStringFromEntity(
                        foldingBikeService.add(foldingBike));
                System.out.println(entityString);
                IndexController.newLines.add(entityString);
                System.out.println("Bike was added successfully.");
            }
        });
        map.put("SPEEDELEC", () -> {
            Speedelec speedelec = buildSpeedelecFromUserInput();
            if (speedelec != null) {
                String entityString = speedelecService.buildStringFromEntity(
                        speedelecService.add(speedelec));
                System.out.println(entityString);
                IndexController.newLines.add(entityString);
                System.out.println("Bike was added successfully.");
            }
        });
        map.put("E-BIKE", () -> {
            Ebike ebike = buildEbikeFromUserInput();
            if (ebike != null) {
                String entityString = ebikeService.buildStringFromEntity(
                        ebikeService.add(ebike));
                System.out.println(entityString);
                IndexController.newLines.add(entityString);
                System.out.println("Bike was added successfully.");
            }
        });
        COMMAND_MAP = Collections.unmodifiableMap(map);
    }

    private static Ebike buildEbikeFromUserInput() {
        Map<String, String> meta = new LinkedHashMap<>() {
            {
                put("brand", null);
                put("maxSpeed", null);
                put("weight", null);
                put("lights", null);
                put("batteryCapacity", null);
                put("color", null);
                put("price", null);
            }
        };

        meta.forEach((key, value) -> {
            while (meta.get(key) == null) {
                System.out.println("Please enter " + key);
                String ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringNotEmpty(ans)
                        || ValidateUtil.validateStringIsBoolean(ans)
                        || ValidateUtil.validateStringIsNumber(ans)) {
                    meta.put(key, ans);
                }
            }
        });

        Ebike ebike = new Ebike();
        try {
            ebike.setBrand(meta.get("brand"));
            ebike.setMaximumSpeed(Integer.parseInt(meta.get("maxSpeed")));
            ebike.setWeight(Integer.parseInt(meta.get("weight")));
            ebike.setLights(meta.get("lights").equalsIgnoreCase("true"));
            ebike.setBatteryCapacity(Integer.parseInt(meta.get("batteryCapacity")));
            ebike.setColor(meta.get("color"));
            ebike.setPrice(Integer.parseInt(meta.get("price")));
        } catch (Exception e) {
            System.out.println("Entered data is not valid.");
            return null;
        }
        return ebike;
    }

    private static Speedelec buildSpeedelecFromUserInput() {
        Map<String, String> meta = new LinkedHashMap<>() {
            {
                put("brand", null);
                put("maxSpeed", null);
                put("weight", null);
                put("lights", null);
                put("batteryCapacity", null);
                put("color", null);
                put("price", null);
            }
        };

        meta.forEach((key, value) -> {
            while (meta.get(key) == null) {
                System.out.println("Please enter " + key);
                String ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringNotEmpty(ans)
                        || ValidateUtil.validateStringIsBoolean(ans)
                        || ValidateUtil.validateStringIsNumber(ans)) {
                    meta.put(key, ans);
                }
            }
        });

        Speedelec speedelec = new Speedelec();
        try {
            speedelec.setBrand(meta.get("brand"));
            speedelec.setMaximumSpeed(Integer.parseInt(meta.get("maxSpeed")));
            speedelec.setWeight(Integer.parseInt(meta.get("weight")));
            speedelec.setLights(meta.get("lights").equalsIgnoreCase("true"));
            speedelec.setBatteryCapacity(Integer.parseInt(meta.get("batteryCapacity")));
            speedelec.setColor(meta.get("color"));
            speedelec.setPrice(Integer.parseInt(meta.get("price")));
        } catch (Exception e) {
            System.out.println("Entered data is not valid.");
            return null;
        }
        return speedelec;
    }

    private static FoldingBike buildFoldingBikeFromUserInput() {
        Map<String, String> meta = new LinkedHashMap<>() {
            {
                put("brand", null);
                put("wheelSize", null);
                put("numberOfGears", null);
                put("weight", null);
                put("lights", null);
                put("color", null);
                put("price", null);
            }
        };

        meta.forEach((key, value) -> {
            while (meta.get(key) == null) {
                System.out.println("Please enter " + key);
                String ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringNotEmpty(ans)
                        || ValidateUtil.validateStringIsBoolean(ans)
                        || ValidateUtil.validateStringIsNumber(ans)) {
                    meta.put(key, ans);
                }
            }
        });

        FoldingBike foldingBike = new FoldingBike();

        try {
            foldingBike.setBrand(meta.get("brand"));
            foldingBike.setWheelSize(Integer.valueOf(meta.get("wheelSize")));
            foldingBike.setNumberOfGears(Integer.valueOf(meta.get("numberOfGears")));
            foldingBike.setWeight(Integer.valueOf(meta.get("weight")));
            foldingBike.setLights(meta.get("lights").equalsIgnoreCase("true"));
            foldingBike.setColor(meta.get("color"));
            foldingBike.setPrice(Integer.valueOf(meta.get("price")));
        } catch (Exception e) {
            System.out.println("Entered data is not valid.");
            return null;
        }
        return foldingBike;
    }

    private interface Command {
        void execute();
    }

    private void addFoldingBike() {
        FoldingBike foldingBike = new FoldingBike();
    }
}
