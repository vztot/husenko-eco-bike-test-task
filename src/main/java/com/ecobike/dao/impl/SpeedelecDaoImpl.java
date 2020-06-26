package com.ecobike.dao.impl;

import com.ecobike.annotation.Dao;
import com.ecobike.dao.SpeedelecDao;
import com.ecobike.exception.DataProcessingException;
import com.ecobike.model.Speedelec;
import com.ecobike.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class SpeedelecDaoImpl implements SpeedelecDao {

    private static final Logger LOGGER = Logger.getLogger(SpeedelecDaoImpl.class);

    @Override
    public Speedelec add(Speedelec speedelec) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(speedelec);
            transaction.commit();
            return speedelec;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            String msg = "Can't insert Speedelec entity: ";
            LOGGER.fatal(msg + speedelec + " " + e);
            throw new DataProcessingException(msg + speedelec);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Speedelec> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Speedelec> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(Speedelec.class);
            criteriaQuery.from(Speedelec.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            String msg = "Can't get all Speedelecs";
            LOGGER.fatal(msg);
            throw new DataProcessingException(msg);
        }
    }
}
