package com.ecobike;

import com.ecobike.context.ApplicationContext;
import com.ecobike.model.Bike;
import com.ecobike.model.entity.FoldingBike;
import com.ecobike.service.BikeService;
import com.ecobike.util.tree.BinaryTree;
import com.ecobike.util.tree.impl.MyBinaryTreeImpl;
import java.math.BigDecimal;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private static final ApplicationContext ctx = new ApplicationContext();
    private static final BikeService bikeService =
            (BikeService) ctx.getServiceByName("BikeService");

    public static void main(String[] args) {
        BinaryTree<Bike> tree = new MyBinaryTreeImpl<>();
        FoldingBike bike = new FoldingBike("HUY", 100, true, "black",
                new BigDecimal(100), 10, 10);
        tree.add(bike);
        tree.add(bike);
        tree.add(bike);
    }
}
