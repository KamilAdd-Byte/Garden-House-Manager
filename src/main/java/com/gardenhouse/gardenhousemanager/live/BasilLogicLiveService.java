package com.gardenhouse.gardenhousemanager.live;

import com.gardenhouse.gardenhousemanager.model.Basil;

public interface BasilLogicLiveService {
    void sow();
    void showParameters();
    Basil waterIt(double waterConsumption);
    void choiceMethodOfPlanting();
}
