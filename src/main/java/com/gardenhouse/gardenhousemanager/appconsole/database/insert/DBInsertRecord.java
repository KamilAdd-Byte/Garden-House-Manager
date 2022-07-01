package com.gardenhouse.gardenhousemanager.appconsole.database.insert;

import com.gardenhouse.gardenhousemanager.appconsole.database.connect.DBConnector;
import com.gardenhouse.gardenhousemanager.appconsole.database.table.DBCreateTableUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

/**
 * @author Kamil Sulejewski
 * Class responsible for adding a new user to the application database
 * @see com.gardenhouse.gardenhousemanager.appconsole.user.service.impl.UserServiceImpl
 */
@Slf4j
public class DBInsertRecord {

    private static final String SQL_USER = "insert into USER(name,login,password)" + "values('\"+name+\"','\"+login+\"','\"+password +\"')";
    private UserLogged user;

    public DBInsertRecord(UserLogged user) {
        this.user = user;
    }

    /**
     * Added user to database.
     * @param user he is new user create by user
     */
    public static void insertUser(UserLogged user){
        try (Connection connect = getConnection()){
            DBCreateTableUser.createUserTable(connect);
            Statement statement = connect.createStatement();
            statement.executeUpdate(SQL_USER);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DBConnector.connect();
    }
}
