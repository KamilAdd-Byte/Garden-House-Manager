package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.appconsole.database.DbConnector;

public class App {
    public static void main(String[] args) {
        DbConnector.connect();
        LogicApp detail = new LogicApp();
        detail.run();
    }
}
