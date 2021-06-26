package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.model.Herb;
import java.util.List;

public interface HerbService {

    List<Herb> getAllHerbs();

    Herb addHerb(Herb herb);

    Herb findById(int id);

    void deleteHerb(int id);

    Herb updateHerb(int id);
}
