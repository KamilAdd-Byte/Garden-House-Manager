package com.gardenhouse.gardenhousemanager.appconsole.database.table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 */
public class DBCreateTableUser {
    private static  final Logger logger = Logger.getLogger(DBCreateTableUser.class.getName());

    private DBCreateTableUser() { }

    public static void createUserTable(Connection connect){
        try {
            Statement statement = connect.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS USER "
                    + "(id INTEGER auto_increment, "
                    + "name VARCHAR(50), "
                    + "login VARCHAR(50), "
                    + "password VARCHAR(50), "
                    + "PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);
            logger.info("Tabela została utworzona");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
