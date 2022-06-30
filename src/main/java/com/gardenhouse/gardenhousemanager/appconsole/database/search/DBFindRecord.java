package com.gardenhouse.gardenhousemanager.appconsole.database.search;

import java.sql.Connection;
import java.sql.Statement;

public class DBFindRecord {
    private static Connection connection;
    private static Statement statement = null;
    private String sql = "select * from USER ";
    private String login;
}
