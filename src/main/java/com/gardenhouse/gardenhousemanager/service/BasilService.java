package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.control.*;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;

public interface BasilService {
    Basil get(int id);
    String getName();
    String getDescription();
    PlantTemperature getTemperature();
    Wetness getWetness();
    WaterConsumption getWaterConsumption();
    Light getLight();
    MethodOfPlanting choice();
}
