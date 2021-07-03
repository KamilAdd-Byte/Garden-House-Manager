package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;

public interface BasilService {
    Basil get(int id);
    String getName();
    String getDescription();
    PlantTemperature getTemperature();
    Wetness getWetness();
    WaterConsumption getWaterConsumption();
    Light getLight();
}
