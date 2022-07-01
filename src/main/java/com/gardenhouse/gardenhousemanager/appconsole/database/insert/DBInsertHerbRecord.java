package com.gardenhouse.gardenhousemanager.appconsole.database.insert;

import com.gardenhouse.gardenhousemanager.appconsole.database.connect.DBConnector;
import com.gardenhouse.gardenhousemanager.appconsole.database.table.DBCreateTableUser;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class DBInsertHerbRecord {

    private static final String CREATE_HERB = "CREATE TABLE IF NOT EXISTS HERB "
            + "(id INTEGER auto_increment, "
            + "dayLife INTEGER, "
            + "description VARCHAR(50), "
            + "minTemperature number, "
            + "maxTemperature number, ";
    private static final String SQL_HERB = "insert into HERB(idHerb,dayLife,waterConsumptionPerDay,water,light," +
            "description,minTemperature,maxTemperature,growthUp,monthToSow,dateOfSow,conditionHerb,pot,kindOfSoil)";

    private static final String VALUES_HERB =  "values ('\"+name+\"','\"+login+\"','\"+password +\"')";

    private HerbDto herbDto;

    /**
     * Added herbs to database.
     * @param herbDto it is new herb if is not null
     */
    public static void insertHerbs (HerbDto herbDto){
        Connection connect = DBConnector.connect();
        try {
            createHerbTable(connect);
            Statement statement = connect.createStatement();
            statement.executeUpdate(SQL_HERB);
            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        } finally {
            try {
                connect.close();
            } catch (SQLException e) {
                log.error(e.getMessage());
            }
        }
    }

    public static void createHerbTable(Connection connect){
        try (Statement statement = connect.createStatement()){
            String sql = "CREATE TABLE IF NOT EXISTS USER "
                    + "(id INTEGER auto_increment, "
                    + "name VARCHAR(50), "
                    + "login VARCHAR(50), "
                    + "password VARCHAR(50), "
                    + "PRIMARY KEY ( id ))";
            statement.executeUpdate(sql);
            log.info("Tabela została utworzona");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
