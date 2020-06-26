package com.ecobike.dao.impl;

import com.ecobike.annotation.Dao;
import com.ecobike.dao.EbikeDao;
import com.ecobike.exception.DataProcessingException;
import com.ecobike.model.Ebike;
import com.ecobike.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class EbikeDaoImpl implements EbikeDao {

    private static final Logger LOGGER = Logger.getLogger(EbikeDaoImpl.class);

    @Override
    public Ebike add(Ebike ebike) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(ebike);
            transaction.commit();
            return ebike;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't insert Ebike entity: ";
            LOGGER.fatal(msg + ebike + " " + e);
            throw new DataProcessingException(msg + ebike);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Ebike> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Ebike> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Ebike.class);
            criteriaQuery.from(Ebike.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            String msg = "Can't get all Ebikes";
            LOGGER.fatal(msg);
            throw new DataProcessingException(msg);
        }
    }
}
