package com.ecobike.service.impl;

import com.ecobike.annotation.Inject;
import com.ecobike.annotation.Service;
import com.ecobike.dao.FoldingBikeDao;
import com.ecobike.model.FoldingBike;
import com.ecobike.service.FoldingBikeService;
import java.util.List;

@Service
public class FoldingBikeImpl implements FoldingBikeService {

    @Inject
    private FoldingBikeDao foldingBikeDao;

    @Override
    public FoldingBike add(FoldingBike foldingBike) {
        return foldingBikeDao.add(foldingBike);
    }

    @Override
    public List<FoldingBike> getAll() {
        return foldingBikeDao.getAll();
    }

    @Override
    public FoldingBike buildEntityFromString(String s) {
        String[] splitData = s.split("; ");
        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(splitData[0].replace("FOLDING BIKE ", ""));
        foldingBike.setWheelSize(Integer.parseInt(splitData[1]));
        foldingBike.setNumberOfGears(Integer.parseInt(splitData[2]));
        foldingBike.setWeight(Integer.parseInt(splitData[3]));
        foldingBike.setLights(Boolean.parseBoolean(splitData[4]));
        foldingBike.setColor(splitData[5]);
        foldingBike.setPrice(Integer.parseInt(splitData[6]));
        return foldingBike;
    }

    @Override
    public String buildStringFromEntity(FoldingBike foldingBike) {
        StringBuilder sb = new StringBuilder("FOLDING BIKE ");
        sb.append(foldingBike.getBrand()).append("; ");
        sb.append(foldingBike.getWheelSize()).append("; ");
        sb.append(foldingBike.getNumberOfGears()).append("; ");
        sb.append(foldingBike.getWeight()).append("; ");
        sb.append(foldingBike.hasLights()).append("; ");
        sb.append(foldingBike.getColor()).append("; ");
        sb.append(foldingBike.getPrice());
        return sb.toString();
    }
}
