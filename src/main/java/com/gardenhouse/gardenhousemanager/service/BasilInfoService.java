package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.control.*;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;

public interface BasilInfoService {
    Basil get(int id);
    String getName();
    String getDescription();
    PlantTemperature getTemperature();
    Wetness getWetness();
    Light getLight();
    MethodOfPlanting choice();
}
