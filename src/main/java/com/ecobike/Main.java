package com.ecobike;

import com.ecobike.context.ApplicationContext;
import com.ecobike.dao.FoldingBikeDao;
import com.ecobike.db.Database;
import com.ecobike.model.FoldingBike;
import com.ecobike.view.ConsoleHandler;
import java.math.BigDecimal;

public class Main {
    private static FoldingBikeDao foldingBikeDao =
            (FoldingBikeDao) ApplicationContext.getInstance().getService(FoldingBikeDao.class);

    public static void main(String[] args) {
        Database db = new Database();
        ConsoleHandler handler = new ConsoleHandler();

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
    }
}
