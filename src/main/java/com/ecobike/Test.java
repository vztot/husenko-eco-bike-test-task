package com.ecobike;

import com.ecobike.context.AppContext;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.service.EbikeService;
import com.ecobike.service.FoldingBikeService;
import com.ecobike.service.SpeedelecService;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private static FoldingBikeService foldingBikeService =
            (FoldingBikeService) AppContext.getInstance().getService(FoldingBikeService.class);
    private static SpeedelecService speedelecService =
            (SpeedelecService) AppContext.getInstance().getService(SpeedelecService.class);
    private static EbikeService ebikeService =
            (EbikeService) AppContext.getInstance().getService(EbikeService.class);

    public static void main(String[] args) {
        FoldingBike foldingBike1 = new FoldingBike();
        foldingBike1.setBrand("GIANT");
        foldingBike1.setColor("BLUE");
        foldingBike1.setLights(false);
        foldingBike1.setNumberOfGears(12);
        foldingBike1.setPrice(1200);
        foldingBike1.setWeight(5000);
        foldingBike1.setWheelSize(11);

        FoldingBike foldingBike2 = new FoldingBike();
        foldingBike2.setBrand("GIANT2");
        foldingBike2.setColor("BLUE2");
        foldingBike2.setLights(false);
        foldingBike2.setNumberOfGears(13);
        foldingBike2.setPrice(900);
        foldingBike2.setWeight(500);
        foldingBike2.setWheelSize(13);

        foldingBikeService.add(foldingBike1);
        foldingBikeService.add(foldingBike2);
        List<FoldingBike> foldingBikeList = foldingBikeService.getAll().stream()
                .map(foldingBikeService::buildStringFromEntity)
                .map(foldingBikeService::buildEntityFromString)
                .collect(Collectors.toList());

        foldingBike1.setId(null);
        foldingBike2.setId(null);
        System.out.println(foldingBike1.equals(foldingBikeList.get(0)));
        System.out.println(foldingBike2.equals(foldingBikeList.get(1)));

        Speedelec speedelec1 = new Speedelec();
        speedelec1.setBatteryCapacity(5400);
        speedelec1.setBrand("Speedelec Brand one");
        speedelec1.setColor("Blue");
        speedelec1.setLights(false);
        speedelec1.setMaximumSpeed(50);
        speedelec1.setPrice(800);
        speedelec1.setWeight(7000);

        Speedelec speedelec2 = new Speedelec();
        speedelec2.setBatteryCapacity(6800);
        speedelec2.setBrand("Speedelec Brand two");
        speedelec2.setColor("RED");
        speedelec2.setLights(false);
        speedelec2.setMaximumSpeed(69);
        speedelec2.setPrice(1600);
        speedelec2.setWeight(3000);

        speedelecService.add(speedelec1);
        speedelecService.add(speedelec2);
        List<Speedelec> speedelecList = speedelecService.getAll().stream()
                .map(speedelecService::buildStringFromEntity)
                .map(speedelecService::buildEntityFromString)
                .collect(Collectors.toList());

        speedelec1.setId(null);
        speedelec2.setId(null);
        System.out.println(speedelec1.equals(speedelecList.get(0)));
        System.out.println(speedelec2.equals(speedelecList.get(1)));

        Ebike ebike1 = new Ebike();
        ebike1.setBatteryCapacity(5400);
        ebike1.setBrand("Ebike Brand one");
        ebike1.setColor("Blue");
        ebike1.setLights(false);
        ebike1.setMaximumSpeed(50);
        ebike1.setPrice(950);
        ebike1.setWeight(7000);

        Ebike ebike2 = new Ebike();
        ebike2.setBatteryCapacity(6800);
        ebike2.setBrand("Ebike Brand two");
        ebike2.setColor("RED");
        ebike2.setLights(false);
        ebike2.setMaximumSpeed(69);
        ebike2.setPrice(580);
        ebike2.setWeight(3000);

        ebikeService.add(ebike1);
        ebikeService.add(ebike2);
        List<Ebike> ebikeList = ebikeService.getAll().stream()
                .map(ebikeService::buildStringFromEntity)
                .map(ebikeService::buildEntityFromString)
                .collect(Collectors.toList());

        ebike1.setId(null);
        ebike2.setId(null);
        System.out.println(ebike1.equals(ebikeList.get(0)));
        System.out.println(ebike2.equals(ebikeList.get(1)));

        System.out.println(ebike1.toCatalogString());
        System.out.println(foldingBike1.toCatalogString());
        System.out.println(speedelec1.toCatalogString());
    }
}
