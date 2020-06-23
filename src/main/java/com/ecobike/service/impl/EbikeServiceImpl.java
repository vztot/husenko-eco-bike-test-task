package com.ecobike.service.impl;

import com.ecobike.annotation.Inject;
import com.ecobike.dao.EbikeDao;
import com.ecobike.model.Ebike;
import com.ecobike.service.EbikeService;
import java.util.List;

public class EbikeServiceImpl implements EbikeService {

    @Inject
    private EbikeDao ebikeDao;

    @Override
    public Ebike add(Ebike ebike) {
        return ebikeDao.add(ebike);
    }

    @Override
    public List<Ebike> getAll() {
        return ebikeDao.getAll();
    }

    @Override
    public Ebike buildEntityFromString(String s) {
        String[] splitData = s.split("; ");
        Ebike ebike = new Ebike();
        ebike.setBrand(splitData[0].replace("E-BIKE ", ""));
        ebike.setMaximumSpeed(Integer.parseInt(splitData[1]));
        ebike.setWeight(Integer.parseInt(splitData[2]));
        ebike.setLights(Boolean.parseBoolean(splitData[3]));
        ebike.setBatteryCapacity(Integer.parseInt(splitData[4]));
        ebike.setColor(splitData[5]);
        ebike.setPrice(Integer.parseInt(splitData[6]));
        return ebike;
    }

    @Override
    public String buildStringFromEntity(Ebike ebike) {
        StringBuilder sb = new StringBuilder("E-BIKE ");
        sb.append(ebike.getBrand()).append("; ");
        sb.append(ebike.getMaximumSpeed()).append("; ");
        sb.append(ebike.getWeight()).append("; ");
        sb.append(ebike.hasLights()).append("; ");
        sb.append(ebike.getBatteryCapacity()).append("; ");
        sb.append(ebike.getColor()).append("; ");
        sb.append(ebike.getPrice());
        return sb.toString();
    }
}
