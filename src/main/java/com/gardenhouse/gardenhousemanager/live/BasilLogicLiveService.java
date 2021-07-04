package com.gardenhouse.gardenhousemanager.live;

import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;

public interface BasilLogicLiveService {
    void sow();
    Basil showParameters();
    WaterConsumption waterIt(double water);
    void choiceMethodOfPlanting();
}
