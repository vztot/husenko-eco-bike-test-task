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
            String entityString = foldingBikeService.buildStringFromEntity(
                    foldingBikeService.add(foldingBike));
            System.out.println(entityString);
            IndexController.newLines.add(entityString);
            System.out.println("Bike was added successfully.");
        });
        map.put("SPEEDELEC", () -> {
            Speedelec speedelec = buildSpeedelecFromUserInput();
            String entityString = speedelecService.buildStringFromEntity(
                    speedelecService.add(speedelec));
            System.out.println(entityString);
            IndexController.newLines.add(entityString);
            System.out.println("Bike was added successfully.");
        });
        map.put("E-BIKE", () -> {
            Ebike ebike = buildEbikeFromUserInput();
            String entityString = ebikeService.buildStringFromEntity(
                    ebikeService.add(ebike));
            System.out.println(entityString);
            IndexController.newLines.add(entityString);
            System.out.println("Bike was added successfully.");
        });
        COMMAND_MAP = Collections.unmodifiableMap(map);
    }

    private static Ebike buildEbikeFromUserInput() {
        String brand = null;
        Integer maxSpeed = null;
        Integer weight = null;
        Boolean lights = false;
        Integer batteryCapacity = null;
        String color = null;
        Integer price = null;

        while (price == null) {
            String ans = null;
            if (brand == null) {
                System.out.println("Please enter brand:");
                brand = new Scanner(System.in).nextLine();
            }
            if (maxSpeed == null) {
                System.out.println("Please enter max Speed:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    maxSpeed = Integer.parseInt(ans);
                }
            }
            if (weight == null) {
                System.out.println("Please enter weight:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    weight = Integer.parseInt(ans);
                }
            }
            if (lights == null) {
                System.out.println("Does bike has head/tail light? (true/false):");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsBoolean(ans)) {
                    lights = Boolean.parseBoolean(ans);
                }
            }
            if (batteryCapacity == null) {
                System.out.println("Please enter battery capacity:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    batteryCapacity = Integer.parseInt(ans);
                }
            }
            if (color == null) {
                System.out.println("Please enter color:");
                ans = new Scanner(System.in).nextLine();
                color = ans;
            }
            if (price == null) {
                System.out.println("Please enter price:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    price = Integer.parseInt(ans);
                }
            }
        }
        Ebike ebike = new Ebike();
        ebike.setBrand(brand);
        ebike.setMaximumSpeed(maxSpeed);
        ebike.setWeight(weight);
        ebike.setLights(lights);
        ebike.setBatteryCapacity(batteryCapacity);
        ebike.setColor(color);
        ebike.setPrice(price);
        return ebike;
    }

    private static Speedelec buildSpeedelecFromUserInput() {
        String brand = null;
        Integer maxSpeed = null;
        Integer weight = null;
        Boolean lights = false;
        Integer batteryCapacity = null;
        String color = null;
        Integer price = null;

        while (price == null) {
            String ans = null;
            if (brand == null) {
                System.out.println("Please enter brand:");
                brand = new Scanner(System.in).nextLine();
            }
            if (maxSpeed == null) {
                System.out.println("Please enter max Speed:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    maxSpeed = Integer.parseInt(ans);
                }
            }
            if (weight == null) {
                System.out.println("Please enter weight:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    weight = Integer.parseInt(ans);
                }
            }
            if (lights == null) {
                System.out.println("Does bike has head/tail light? (true/false):");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsBoolean(ans)) {
                    lights = Boolean.parseBoolean(ans);
                }
            }
            if (batteryCapacity == null) {
                System.out.println("Please enter battery capacity:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    batteryCapacity = Integer.parseInt(ans);
                }
            }
            if (color == null) {
                System.out.println("Please enter color:");
                ans = new Scanner(System.in).nextLine();
                color = ans;
            }
            if (price == null) {
                System.out.println("Please enter price:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    price = Integer.parseInt(ans);
                }
            }
        }
        Speedelec speedelec = new Speedelec();
        speedelec.setBrand(brand);
        speedelec.setMaximumSpeed(maxSpeed);
        speedelec.setWeight(weight);
        speedelec.setLights(lights);
        speedelec.setBatteryCapacity(batteryCapacity);
        speedelec.setColor(color);
        speedelec.setPrice(price);
        return speedelec;
    }

    private static FoldingBike buildFoldingBikeFromUserInput() {
        String brand = null;
        Integer wheelSize = null;
        Integer numOfGears = null;
        Integer weight = null;
        Boolean lights = false;
        String color = null;
        Integer price = null;
        while (price == null) {
            String ans = null;
            if (brand == null) {
                System.out.println("Please enter brand:");
                brand = new Scanner(System.in).nextLine();
            }
            if (wheelSize == null) {
                System.out.println("Please enter wheel size:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    wheelSize = Integer.parseInt(ans);
                }
            }
            if (numOfGears == null) {
                System.out.println("Please enter count of gears:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    numOfGears = Integer.parseInt(ans);
                }
            }
            if (weight == null) {
                System.out.println("Please enter weight:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    weight = Integer.parseInt(ans);
                }
            }
            if (lights == null) {
                System.out.println("Does bike has head/tail light? (true/false):");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsBoolean(ans)) {
                    lights = Boolean.parseBoolean(ans);
                }
            }
            if (color == null) {
                System.out.println("Please enter color:");
                ans = new Scanner(System.in).nextLine();
                color = ans;
            }
            if (price == null) {
                System.out.println("Please enter price:");
                ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringIsNumber(ans)) {
                    price = Integer.parseInt(ans);
                }
            }
        }
        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(brand);
        foldingBike.setWheelSize(wheelSize);
        foldingBike.setNumberOfGears(numOfGears);
        foldingBike.setWeight(weight);
        foldingBike.setLights(lights);
        foldingBike.setColor(color);
        foldingBike.setPrice(price);
        return foldingBike;
    }

    private interface Command {
        void execute();
    }

    private void addFoldingBike() {
        FoldingBike foldingBike = new FoldingBike();
    }
}
