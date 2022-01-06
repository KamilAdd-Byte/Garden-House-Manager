package com.gardenhouse.gardenhousemanager.appconsole.database.insert;

import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;

import java.sql.Connection;
import java.sql.Statement;

public class DBFindRecord {
    private static Connection connection;
    private static Statement statement = null;
    private String sql = "select * from USER ";
    private String login;
}
