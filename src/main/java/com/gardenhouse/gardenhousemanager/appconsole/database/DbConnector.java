package com.gardenhouse.gardenhousemanager.appconsole.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DbConnector {
    private static final Logger logger = Logger.getLogger(DbConnector.class.getName());
    private static final String URL = "jdbc:h2:file:./herbs";

    private DbConnector() {
    }

    public static Connection connect (){
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(URL);
            logger.info("Połączono z bazą danych");
        } catch (SQLException e) {
            logger.warning("Brak połaczenia z bazą danych");
            e.printStackTrace();
        }
        return connection;
    }
}
