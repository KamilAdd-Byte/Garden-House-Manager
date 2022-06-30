package com.gardenhouse.gardenhousemanager.appconsole.database.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Kamil Sulejewski

 * Connection to H2 database.
 * @see com.gardenhouse.gardenhousemanager.appconsole.App calling the connect() method.
 */
public class DBConnector {
    private static final Logger logger = Logger.getLogger(DBConnector.class.getName());
    private static final String URL = "jdbc:h2:file:./herbs";

    private DBConnector() {
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
