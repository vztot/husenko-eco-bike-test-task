package com.ecobike;

import com.ecobike.context.ApplicationContext;
import com.ecobike.dao.EbikeDao;
import com.ecobike.dao.FoldingBikeDao;
import com.ecobike.dao.SpeedelecDao;
import com.ecobike.db.Database;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import java.math.BigDecimal;

public class Main {
    private static FoldingBikeDao foldingBikeDao =
            (FoldingBikeDao) ApplicationContext.getInstance().getService(FoldingBikeDao.class);
    private static SpeedelecDao speedelecDao =
            (SpeedelecDao) ApplicationContext.getInstance().getService(SpeedelecDao.class);
    private static EbikeDao ebikeDao =
            (EbikeDao) ApplicationContext.getInstance().getService(EbikeDao.class);

    public static void main(String[] args) {
        Database db = new Database();

        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand("GIANT");
        foldingBike.setColor("BLUE");
        foldingBike.setLights(true);
        foldingBike.setNumberOfGears(12);
        foldingBike.setPrice(new BigDecimal(1000));
        foldingBike.setWeight(5000);
        foldingBike.setWheelSize(11);

        FoldingBike foldingBike2 = new FoldingBike();
        foldingBike2.setBrand("GIANT2");
        foldingBike2.setColor("BLUE2");
        foldingBike2.setLights(false);
        foldingBike2.setNumberOfGears(13);
        foldingBike2.setPrice(new BigDecimal(200));
        foldingBike2.setWeight(500);
        foldingBike2.setWheelSize(13);

        foldingBikeDao.add(foldingBike);
        foldingBikeDao.add(foldingBike2);
        System.out.println(foldingBikeDao.getAll());

        Speedelec speedelec1 = new Speedelec();
        speedelec1.setBatteryCapacity(5400);
        speedelec1.setBrand("Speedelec Brand one");
        speedelec1.setColor("Blue");
        speedelec1.setLights(true);
        speedelec1.setMaximumSpeed(50);
        speedelec1.setPrice(new BigDecimal(1200));
        speedelec1.setWeight(7000);

        Speedelec speedelec2 = new Speedelec();
        speedelec2.setBatteryCapacity(6800);
        speedelec2.setBrand("Speedelec Brand two");
        speedelec2.setColor("RED");
        speedelec2.setLights(true);
        speedelec2.setMaximumSpeed(69);
        speedelec2.setPrice(new BigDecimal(900));
        speedelec2.setWeight(3000);

        speedelecDao.add(speedelec1);
        speedelecDao.add(speedelec1);
        System.out.println(speedelecDao.getAll());

        Ebike ebike1 = new Ebike();
        ebike1.setBatteryCapacity(5400);
        ebike1.setBrand("Ebike Brand one");
        ebike1.setColor("Blue");
        ebike1.setLights(true);
        ebike1.setMaximumSpeed(50);
        ebike1.setPrice(new BigDecimal(1200));
        ebike1.setWeight(7000);

        Ebike ebike2 = new Ebike();
        ebike2.setBatteryCapacity(6800);
        ebike2.setBrand("Ebike Brand two");
        ebike2.setColor("RED");
        ebike2.setLights(true);
        ebike2.setMaximumSpeed(69);
        ebike2.setPrice(new BigDecimal(900));
        ebike2.setWeight(3000);

        ebikeDao.add(ebike1);
        ebikeDao.add(ebike2);
        System.out.println(ebikeDao.getAll());
    }
}
