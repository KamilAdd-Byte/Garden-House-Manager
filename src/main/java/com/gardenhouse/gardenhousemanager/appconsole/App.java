package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.database.DBConnector;
import com.gardenhouse.gardenhousemanager.appconsole.database.table.DBCreateTableUser;

import java.sql.Connection;

public class App {
    public static void main(String[] args) {
        Connection connect = DBConnector.connect();
        DBCreateTableUser.createUserTable(connect);
        LogicApp detail = new LogicApp();
        detail.run();
    }
}
