package com.gardenhouse.gardenhousemanager.appconsole.database;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.List;

/**
 * @author kamillodzinski
 * Klasa tylko wyświetla listę ziół z bazy
 */
public class LogicAppHerbs {
    private final DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();

    public void displayAllHerbsInDataBase (){
        List<HerbDetail> herbDetailList = dataBaseForHerbs.allHerbs();
        herbDetailList.forEach(System.out::println);
    }
}
