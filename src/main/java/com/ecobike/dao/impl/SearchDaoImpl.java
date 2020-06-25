package com.ecobike.dao.impl;

import com.ecobike.annotation.Dao;
import com.ecobike.dao.SearchDao;
import com.ecobike.exception.DataProcessingException;
import com.ecobike.model.Ebike;
import com.ecobike.model.FoldingBike;
import com.ecobike.model.Speedelec;
import com.ecobike.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

@Dao
public class SearchDaoImpl implements SearchDao {

    @Override
    public List<FoldingBike> searchFoldingBike(FoldingBike foldingBike) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<FoldingBike> users =
                    session.createQuery("FROM FoldingBike WHERE brand = '"
                                    + foldingBike.getBrand() + "'",
                            FoldingBike.class);
            return users.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Unable to get foldingBikes");
        }
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
