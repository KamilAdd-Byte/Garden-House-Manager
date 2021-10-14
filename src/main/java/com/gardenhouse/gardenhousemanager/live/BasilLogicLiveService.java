package com.gardenhouse.gardenhousemanager.live;

import com.gardenhouse.gardenhousemanager.model.Basil;

public interface BasilLogicLiveService {
    void sow();
    Basil showParameters();
    Basil waterIt(double waterConsumption);
    void choiceMethodOfPlanting();
}
