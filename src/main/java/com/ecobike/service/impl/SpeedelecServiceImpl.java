package com.ecobike.service.impl;

import com.ecobike.annotation.Inject;
import com.ecobike.annotation.Service;
import com.ecobike.dao.SpeedelecDao;
import com.ecobike.model.Speedelec;
import com.ecobike.service.SpeedelecService;
import java.util.List;

@Service
public class SpeedelecServiceImpl implements SpeedelecService {

    @Inject
    private SpeedelecDao speedelecDao;

    @Override
    public Speedelec add(Speedelec speedelec) {
        return speedelecDao.add(speedelec);
    }

    @Override
    public List<Speedelec> getAll() {
        return speedelecDao.getAll();
    }

    @Override
    public Speedelec buildEntityFromString(String s) {
        String[] splitData = s.split("; ");
        Speedelec speedelec = new Speedelec();
        speedelec.setBrand(splitData[0].replace("SPEEDELEC ", ""));
        speedelec.setMaximumSpeed(Integer.parseInt(splitData[1]));
        speedelec.setWeight(Integer.parseInt(splitData[2]));
        speedelec.setLights(Boolean.parseBoolean(splitData[3]));
        speedelec.setBatteryCapacity(Integer.parseInt(splitData[4]));
        speedelec.setColor(splitData[5]);
        speedelec.setPrice(Integer.parseInt(splitData[6]));
        return speedelec;
    }

    @Override
    public String buildStringFromEntity(Speedelec speedelec) {
        StringBuilder sb = new StringBuilder("SPEEDELEC ");
        sb.append(speedelec.getBrand()).append("; ");
        sb.append(speedelec.getMaximumSpeed()).append("; ");
        sb.append(speedelec.getWeight()).append("; ");
        sb.append(speedelec.hasLights()).append("; ");
        sb.append(speedelec.getBatteryCapacity()).append("; ");
        sb.append(speedelec.getColor()).append("; ");
        sb.append(speedelec.getPrice());
        return sb.toString();
    }
}
