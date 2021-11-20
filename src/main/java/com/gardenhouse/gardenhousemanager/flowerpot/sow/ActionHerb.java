package com.gardenhouse.gardenhousemanager.flowerpot.sow;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

/**
 * Interface has a methods sow and water for herbs
 * @see com.gardenhouse.gardenhousemanager.flowerpot.FlowerPot
 */
public interface ActionHerb {
    void sow(HerbDetail pot);
    void water(HerbDetail herb,double waterMl);
    int getDayOfLife(HerbDetail herb);
}
