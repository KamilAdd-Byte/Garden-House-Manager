package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.control.*;
import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.planting.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;

public interface BasilInfoService {
    Basil get(int id);
    String getName();
    String getDescription();
    BasilTemperature getTemperature();
    Wetness getWetness();
    Light getLight();
    MethodOfPlanting choice();
}
