package com.ecobike.dao.impl;

import com.ecobike.annotation.Dao;
import com.ecobike.dao.SearchDao;
import com.ecobike.exception.DataProcessingException;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.util.HibernateUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class SearchDaoImpl implements SearchDao {

    @Override
    public List<FoldingBike> searchFoldingBike(FoldingBike foldingBike) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM FoldingBike";
            Query query = session.createQuery(hql);
            List<FoldingBike> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get foldingBikes");
        }
    }

    private String buildFoldingBikeQuery(FoldingBike foldingBike) {
        StringBuilder sb = new StringBuilder("FROM FoldingBike");

        Map<String, String> meta = new LinkedHashMap<>() {
            {
                put("brand", foldingBike.getBrand());
                put("wheelSize", foldingBike.getBrand());
                put("numberOfGears", foldingBike.getBrand());
                put("lights", foldingBike.getBrand());
                put("weight", foldingBike.getBrand());
                put("color", foldingBike.getBrand());
                put("price", foldingBike.getBrand());
            }
        };
        if (foldingBike.getBrand() != null
                || foldingBike.getWheelSize() != null
                || foldingBike.getNumberOfGears() != null
                || foldingBike.hasLights() != null
                || foldingBike.getWeight() != null
                || foldingBike.getColor() != null
                || foldingBike.getPrice() != null) {
            sb.append(" WHERE ");
        }

        if (foldingBike.getBrand() != null) {
            sb.append("brand='").append(foldingBike.getBrand()).append("'");
        }
        if (foldingBike.getWheelSize() != null) {
            sb.append("wheelSize='").append(foldingBike.getBrand()).append("'");
        }
        if (foldingBike.getNumberOfGears() != null) {
            sb.append("brand ='").append(foldingBike.getBrand()).append("'");
        }
        if (foldingBike.getBrand() != null) {
            sb.append("brand ='").append(foldingBike.getBrand()).append("'");
        }
        if (foldingBike.getBrand() != null) {
            sb.append("brand ='").append(foldingBike.getBrand()).append("'");
        }
        if (foldingBike.getBrand() != null) {
            sb.append("brand ='").append(foldingBike.getBrand()).append("'");
        }
        if (foldingBike.getBrand() != null) {
            sb.append("brand ='").append(foldingBike.getBrand()).append("'");
        }

        return sb.toString();
    }

    @Override
    public List<Speedelec> searchSpeedelec(Speedelec speedelec) {
        return null;
    }

    @Override
    public List<Ebike> searchEbike(Ebike ebike) {
        return null;
    }
}
