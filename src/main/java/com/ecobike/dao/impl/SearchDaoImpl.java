package com.ecobike.dao.impl;

import com.ecobike.annotation.Dao;
import com.ecobike.dao.SearchDao;
import com.ecobike.exception.DataProcessingException;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.util.HibernateUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class SearchDaoImpl implements SearchDao {

    @Override
    public List<FoldingBike> searchFoldingBike(FoldingBike foldingBike) {
        System.out.println("Parameters: " + foldingBike);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM FoldingBike" + buildFoldingBikeQuery(foldingBike);
            System.out.println("HQL: " + hql);
            Query query = session.createQuery(hql);
            List<FoldingBike> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get foldingBikes");
        }
    }

    @Override
    public List<FoldingBike> searchFirstFoldingBike(FoldingBike foldingBike) {
        System.out.println("Parameters: " + foldingBike);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM FoldingBike" + buildFoldingBikeQuery(foldingBike);
            System.out.println("HQL: " + hql);
            Query query = session.createQuery(hql).setMaxResults(1);
            List<FoldingBike> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get foldingBike");
        }
    }

    @Override
    public List<Speedelec> searchSpeedelec(Speedelec speedelec) {
        System.out.println("Parameters: " + speedelec);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Speedelec" + buildSpeedelecQuery(speedelec);
            System.out.println("HQL: " + hql);
            Query query = session.createQuery(hql);
            List<Speedelec> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get speedelecs");
        }
    }

    @Override
    public List<Speedelec> searchFirstSpeedelec(Speedelec speedelec) {
        System.out.println("Parameters: " + speedelec);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Speedelec" + buildSpeedelecQuery(speedelec);
            System.out.println("HQL: " + hql);
            Query query = session.createQuery(hql).setMaxResults(1);
            List<Speedelec> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get speedelec");
        }
    }

    @Override
    public List<Ebike> searchEbike(Ebike ebike) {
        System.out.println("Parameters: " + ebike);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Ebike" + buildEbikeQuery(ebike);
            System.out.println("HQL: " + hql);
            Query query = session.createQuery(hql);
            List<Ebike> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get ebike");
        }
    }

    @Override
    public List<Ebike> searchFirstEbike(Ebike ebike) {
        System.out.println("Parameters: " + ebike);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Ebike" + buildEbikeQuery(ebike);
            System.out.println("HQL: " + hql);
            Query query = session.createQuery(hql).setMaxResults(1);
            List<Ebike> bikes = query.list();
            return bikes;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get ebikes");
        }
    }

    private String buildFoldingBikeQuery(FoldingBike foldingBike) {
        Map<String, Object> meta = new LinkedHashMap<>() {
            {
                put("brand", foldingBike.getBrand());
                put("wheelSize", foldingBike.getWheelSize());
                put("numberOfGears", foldingBike.getNumberOfGears());
                put("weight", foldingBike.getWeight());
                put("lights", foldingBike.hasLights());
                put("color", foldingBike.getColor());
                put("price", foldingBike.getPrice());
            }
        };

        List<String> properties = new ArrayList<>();
        meta.forEach((key, value) -> {
            if (value != null) {
                properties.add(key + "='" + value + "'");
            }
        });

        String result = "";
        if (properties.size() > 0) {
            result = String.join(" AND ", properties);
            result = " WHERE " + result;
        }
        return result;
    }

    private String buildSpeedelecQuery(Speedelec speedelec) {
        Map<String, Object> meta = new LinkedHashMap<>() {
            {
                put("brand", speedelec.getBrand());
                put("maxSpeed", speedelec.getMaximumSpeed());
                put("weight", speedelec.getWeight());
                put("lights", speedelec.hasLights());
                put("batteryCapacity", speedelec.getBatteryCapacity());
                put("color", speedelec.getColor());
                put("price", speedelec.getPrice());
            }
        };

        List<String> properties = new ArrayList<>();
        meta.forEach((key, value) -> {
            if (value != null) {
                properties.add(key + "='" + value + "'");
            }
        });

        String result = "";
        if (properties.size() > 0) {
            result = String.join(" AND ", properties);
            result = " WHERE " + result;
        }
        return result;
    }

    private String buildEbikeQuery(Ebike ebike) {
        Map<String, Object> meta = new LinkedHashMap<>() {
            {
                put("brand", ebike.getBrand());
                put("maxSpeed", ebike.getMaximumSpeed());
                put("weight", ebike.getWeight());
                put("lights", ebike.hasLights());
                put("batteryCapacity", ebike.getBatteryCapacity());
                put("color", ebike.getColor());
                put("price", ebike.getPrice());
            }
        };

        List<String> properties = new ArrayList<>();
        meta.forEach((key, value) -> {
            if (value != null) {
                properties.add(key + "='" + value + "'");
            }
        });

        String result = "";
        if (properties.size() > 0) {
            result = String.join(" AND ", properties);
            result = " WHERE " + result;
        }
        return result;
    }

    @Override
    public List<Object> executeHql(String queryString) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = queryString;
            Query query = session.createQuery(hql);
            List<Object> result = query.list();
            return result;
        } catch (Exception e) {
            throw new DataProcessingException("Unable to execute query");
        }
    }
}
