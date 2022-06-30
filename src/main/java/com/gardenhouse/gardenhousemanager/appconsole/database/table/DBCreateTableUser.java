package com.gardenhouse.gardenhousemanager.appconsole.database.table;

import lombok.extern.slf4j.Slf4j;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create a USER table
 */
@Slf4j
public class DBCreateTableUser {

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
            log.info("Tabela została utworzona");
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}