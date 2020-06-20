package com.ecobike;

import com.ecobike.context.ApplicationContext;
import com.ecobike.service.BikeService;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final BikeService bikeService =
            (BikeService) ApplicationContext.getInstance().getService(BikeService.class);

    public static void main(String[] args) {
//        BinaryTree<Bike> tree = new MyBinaryTreeImpl<>();
//        FoldingBike bike = new FoldingBike("HUY", 100, true, "black",
//                new BigDecimal(100), 10, 10);
//        tree.add(bike);
//        tree.add(bike);
//        tree.add(bike);
        Controller controller = new Controller();
        System.out.println(bikeService);
        System.out.println(controller.getServiceRef());
    }
}
