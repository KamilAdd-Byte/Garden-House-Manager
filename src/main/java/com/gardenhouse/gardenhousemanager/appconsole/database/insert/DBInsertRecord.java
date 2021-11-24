package com.gardenhouse.gardenhousemanager.appconsole.database.insert;

import com.gardenhouse.gardenhousemanager.appconsole.database.DBConnector;
import java.sql.*;

public class DBInsertRecord {
    private static Connection connection;
    private static Statement statement = null;
    private String sql = "";

    static {
        try {
            statement = DBConnector.connect().createStatement();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DBConnector.connect();
    }
}
