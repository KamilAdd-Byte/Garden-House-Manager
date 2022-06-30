package com.gardenhouse.gardenhousemanager.appconsole.database.insert;

import com.gardenhouse.gardenhousemanager.appconsole.database.connect.DBConnector;
import com.gardenhouse.gardenhousemanager.appconsole.database.table.DBCreateTableUser;
import com.gardenhouse.gardenhousemanager.appconsole.user.UserLogged;
import java.sql.*;

/**
 * @author Kamil Sulejewski
 * Class responsible for adding a new user to the application database
 * @see com.gardenhouse.gardenhousemanager.appconsole.user.service.impl.UserServiceImpl
 */
public class DBInsertRecord {
    private UserLogged user;

    public DBInsertRecord(UserLogged user) {
        this.user = user;
    }

    /**
     * Added user to database.
     * @param user he is new user create by user
     */
    public static void insertUser(UserLogged user){
        Connection connect = DBConnector.connect();
        try {
            DBCreateTableUser.createUserTable(connect);
            Statement statement = connect.createStatement();
            String sql = "insert into USER(name,login,password)" + "values('\"+name+\"','\"+login+\"','\"+password +\"')";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() throws SQLException {
        return DBConnector.connect();
    }
}
