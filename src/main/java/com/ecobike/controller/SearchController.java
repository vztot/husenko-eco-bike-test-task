package com.ecobike.controller;

import com.ecobike.annotation.Controller;
import com.ecobike.context.AppContext;
import com.ecobike.model.FoldingBike;
import com.ecobike.service.EbikeService;
import com.ecobike.service.FoldingBikeService;
import com.ecobike.service.SearchService;
import com.ecobike.service.SpeedelecService;
import com.ecobike.util.OutputUtil;
import com.ecobike.util.ValidateUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

@Controller
public class SearchController {
    private FoldingBikeService foldingBikeService =
            (FoldingBikeService) AppContext.getInstance().getService(FoldingBikeService.class);
    private EbikeService ebikeService =
            (EbikeService) AppContext.getInstance().getService(EbikeService.class);
    private SpeedelecService speedelecService =
            (SpeedelecService) AppContext.getInstance().getService(SpeedelecService.class);
    private SearchService searchService =
            (SearchService) AppContext.getInstance().getService(SearchService.class);
    private String bikeType;

    public SearchController() {
        System.out.println("Select type of a bike you would like to search: \n"
                + "    1 - Folding bike\n"
                + "    2 - Speedelec\n"
                + "    3 - E-bike");
        while (bikeType == null) {
            String ans = new Scanner(System.in).nextLine();
            if (ans.equals("1") || ans.equals("2") || ans.equals("3")) {
                bikeType = ans;
            }
        }
        switch (bikeType) {
            case "1": {
                searchFoldingBike();
                break;
            }
            case "2": {
                searchSpeedelec();
                break;
            }
            case "3": {
                searchEbike();
                break;
            }
            default: {

            }
        }
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

        System.out.println("Controller: " + foldingBike);
        OutputUtil.soutListWithPages(searchService.searchFoldingBike(foldingBike).stream().map(e
                -> e.toCatalogString()).collect(Collectors.toList()));
    }

    private void searchSpeedelec() {

    }

    private void searchEbike() {

    }
}
