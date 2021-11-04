package com.gardenhouse.gardenhousemanager.appconsole.database;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.List;

public class LogicAppHerbs {
    private final DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();

    public List<HerbDetail> displayAllHerbsInDataBase (){
        return dataBaseForHerbs.allHerbs();
    }
}
