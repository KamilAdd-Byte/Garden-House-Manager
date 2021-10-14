package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.control.*;
import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.model.BasilTemperature;

public interface BasilInfoService {
    Basil get(int id);
    String getName();
    String getDescription();
    BasilTemperature getTemperature();
    Wetness getWetness();
    Light getLight();
    MethodOfPlanting choice();
}
