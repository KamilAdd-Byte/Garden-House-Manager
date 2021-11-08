package com.gardenhouse.gardenhousemanager.flowerpot.sow;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

public interface SowHerb {
    void sow(HerbDetail.FlowerPot pot);
    void water(HerbDetail herb,double waterMl);
    int getDayOfLife(HerbDetail herb);
}
