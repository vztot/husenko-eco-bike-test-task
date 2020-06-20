package com.ecobike;

import com.ecobike.context.ApplicationContext;
import com.ecobike.service.BikeService;
import org.apache.log4j.Logger;

public class Controller {
    private BikeService bikeService =
            (BikeService) ApplicationContext.getInstance().getService(BikeService.class);

    public String getServiceRef() {
        return bikeService.toString();
    }
}
