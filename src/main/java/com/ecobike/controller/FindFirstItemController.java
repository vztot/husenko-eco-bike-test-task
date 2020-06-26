package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.context.AppContext;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.service.SearchService;
import com.ecobike.util.OutputUtil;
import com.ecobike.util.ValidateUtil;
import dnl.utils.text.table.TextTable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
public class FindFirstItemController {
    private SearchService searchService =
            (SearchService) AppContext.getInstance().getService(SearchService.class);

    public FindFirstItemController() {
        drawMenu();
        String ans = "";
        while (!ans.equals("1") || !ans.equals("2") || !ans.equals("3") || !ans.equals("4")) {
            ans = new Scanner(System.in).nextLine();
            switch (ans) {
                case "1": {
                    searchFirstFoldingBike();
                    return;
                }
                case "2": {
                    searchFirstSpeedelec();
                    return;
                }
                case "3": {
                    searchFirstEbike();
                    return;
                }
                case "4": {
                    return;
                }
                default: {
                }
            }
        }
    }

    private void drawMenu() {
        TextTable table = new TextTable(new String[]{"#", "Select type of a bike you would like "
                + "to search:"}, new String[][]
                {
                        {"1", "Folding bike"},
                        {"2", "Speedelec"},
                        {"3", "E-bike"},
                        {"4", "Back"},
                });
        table.printTable();
        System.out.println();
    }

    private void searchFirstFoldingBike() {
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
            if (value == null) {
                System.out.println("Please enter " + key + " or press [enter] to pass");
                String ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringNotEmpty(ans)
                        || ValidateUtil.validateStringIsBoolean(ans)
                        || ValidateUtil.validateStringIsNumber(ans)) {
                    meta.put(key, ans);
                }
            }
        });

        FoldingBike foldingBike = new FoldingBike();

        //here is a lot of ternary operators that make null check before parse
        try {
            foldingBike.setBrand(meta.get("brand"));
            foldingBike.setWheelSize(meta.get("wheelSize") == null
                    ? null : Integer.valueOf(meta.get("wheelSize")));
            foldingBike.setNumberOfGears(meta.get("numberOfGears") == null
                    ? null : Integer.valueOf(meta.get("numberOfGears")));
            foldingBike.setWeight(meta.get("weight") == null
                    ? null : Integer.valueOf(meta.get("weight")));
            foldingBike.setLights(meta.get("lights") == null
                    ? null : meta.get("lights").equalsIgnoreCase("true"));
            foldingBike.setColor(meta.get("color"));
            foldingBike.setPrice(meta.get("price") == null
                    ? null : Integer.valueOf(meta.get("price")));
        } catch (Exception e) {
            System.out.println("Entered data are not valid.");
        }

        OutputUtil.soutListWithPages(searchService.searchFirstFoldingBike(foldingBike).stream()
                .map(e -> e.toCatalogString())
                .collect(Collectors.toList()));
    }

    private void searchFirstSpeedelec() {
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
            if (value == null) {
                System.out.println("Please enter " + key + " or press [enter] to pass");
                String ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringNotEmpty(ans)
                        || ValidateUtil.validateStringIsBoolean(ans)
                        || ValidateUtil.validateStringIsNumber(ans)) {
                    meta.put(key, ans);
                }
            }
        });

        Speedelec speedelec = new Speedelec();
        //here is a lot of ternary operators that make null check before parse
        try {
            speedelec.setBrand(meta.get("brand"));
            speedelec.setMaximumSpeed(meta.get("maxSpeed") == null ? null
                    : Integer.parseInt(meta.get("maxSpeed")));
            speedelec.setWeight(meta.get("weight") == null ? null
                    : Integer.parseInt(meta.get("weight")));
            speedelec.setLights(meta.get("lights") == null ? null
                    : meta.get("lights").equalsIgnoreCase("true"));
            speedelec.setBatteryCapacity(meta.get("batteryCapacity") == null ? null
                    : Integer.parseInt(meta.get("batteryCapacity")));
            speedelec.setColor(meta.get("color"));
            speedelec.setPrice(meta.get("price") == null ? null
                    : Integer.parseInt(meta.get("price")));
        } catch (Exception e) {
            System.out.println("Entered data is not valid.");
        }

        OutputUtil.soutListWithPages(searchService.searchFirstSpeedelec(speedelec).stream()
                .map(e -> e.toCatalogString())
                .collect(Collectors.toList()));
    }

    private void searchFirstEbike() {
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
            if (value == null) {
                System.out.println("Please enter " + key + " or press [enter] to pass");
                String ans = new Scanner(System.in).nextLine();
                if (ValidateUtil.validateStringNotEmpty(ans)
                        || ValidateUtil.validateStringIsBoolean(ans)
                        || ValidateUtil.validateStringIsNumber(ans)) {
                    meta.put(key, ans);
                }
            }
        });

        Ebike ebike = new Ebike();
        //here is a lot of ternary operators that make null check before parse
        try {
            ebike.setBrand(meta.get("brand"));
            ebike.setMaximumSpeed(meta.get("maxSpeed") == null ? null
                    : Integer.parseInt(meta.get("maxSpeed")));
            ebike.setWeight(meta.get("weight") == null ? null
                    : Integer.parseInt(meta.get("weight")));
            ebike.setLights(meta.get("lights") == null ? null
                    : meta.get("lights").equalsIgnoreCase("true"));
            ebike.setBatteryCapacity(meta.get("batteryCapacity") == null ? null
                    : Integer.parseInt(meta.get("batteryCapacity")));
            ebike.setColor(meta.get("color"));
            ebike.setPrice(meta.get("price") == null ? null
                    : Integer.parseInt(meta.get("price")));
        } catch (Exception e) {
            System.out.println("Entered data is not valid.");
        }

        OutputUtil.soutListWithPages(searchService.searchFirstEbike(ebike).stream()
                .map(e -> e.toCatalogString())
                .collect(Collectors.toList()));
    }
}
