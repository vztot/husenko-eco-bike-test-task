package com.ecobike.controller;

import com.ecobike.annotation.Service;
import com.ecobike.context.AppContext;
import com.ecobike.model.FoldingBike;
import com.ecobike.service.SearchService;
import com.ecobike.util.OutputUtil;
import com.ecobike.util.ValidateUtil;
import dnl.utils.text.table.TextTable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class FindFirstItemController {
    private SearchService searchService =
            (SearchService) AppContext.getInstance().getService(SearchService.class);

    public FindFirstItemController() {
        drawMenu();
        String ans = "";
        String bikeType = "";
        while (!ans.equals("1") || !ans.equals("2") || !ans.equals("3") || !ans.equals("4")) {
            ans = new Scanner(System.in).nextLine();
            switch (ans) {
                case "1": {
                    searchFoldingBike();
                    return;
                }
                case "2": {
                    searchSpeedelec();
                    return;
                }
                case "3": {
                    searchEbike();
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

    private void searchFoldingBike() {
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

        System.out.println("Parameters: " + foldingBike);
        OutputUtil.soutListWithPages(searchService.searchFoldingBike(foldingBike).stream()
                .limit(1)
                .map(e -> e.toCatalogString())
                .collect(Collectors.toList()));
    }

    private void searchSpeedelec() {

    }

    private void searchEbike() {

    }
}
