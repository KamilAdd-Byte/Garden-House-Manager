package com.gardenhouse.gardenhousemanager.flowerpot.sow;

import com.gardenhouse.gardenhousemanager.control.daylife.Condition;
import com.gardenhouse.gardenhousemanager.flowerpot.FlowerPot;
import com.gardenhouse.gardenhousemanager.model.HerbDto;

/**
 * Interface has a methods sow and water for herbs
 * @see com.gardenhouse.gardenhousemanager.flowerpot.FlowerPot
 */
public interface ActionHerb {
    void sow(HerbDto pot);
    void water(HerbDto herb, double waterMl);
    int getDayOfLife(HerbDto herb);
    void conditionDisplay(Condition condition, HerbDto herb, FlowerPot pot);
}
