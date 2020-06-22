package com.ecobike.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = initSessionFactory();
    private static final Logger LOGGER = Logger.getLogger(HibernateUtil.class);

    private HibernateUtil() {
    }

    private static SessionFactory initSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            String msg = "Failed to create Session Factory";
            LOGGER.fatal(msg, e);
            throw new RuntimeException(msg, e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
