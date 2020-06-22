package com.ecobike.db;

import org.apache.log4j.Logger;

public class Database {
    private static final Logger LOGGER = Logger.getLogger(Database.class);

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.fatal("Can't init db");
        }
    }
}
