package com.ecobike.dao.impl;

import com.ecobike.annotation.Dao;
import com.ecobike.dao.FoldingBikeDao;
import com.ecobike.exception.DataProcessingException;
import com.ecobike.model.FoldingBike;
import com.ecobike.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class FoldingBikeDaoImpl implements FoldingBikeDao {

    private static final Logger LOGGER = Logger.getLogger(FoldingBikeDaoImpl.class);

    @Override
    public FoldingBike add(FoldingBike foldingBike) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(foldingBike);
            transaction.commit();
            return foldingBike;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't insert foldingBike entity: ";
            LOGGER.fatal(msg + foldingBike + " " + e);
            throw new DataProcessingException(msg + foldingBike);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<FoldingBike> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<FoldingBike> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(FoldingBike.class);
            criteriaQuery.from(FoldingBike.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            String msg = "Can't get all foldingBikes";
            LOGGER.fatal(msg);
            throw new DataProcessingException(msg);
        }
    }
}
