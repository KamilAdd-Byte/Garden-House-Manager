package com.gardenhouse.gardenhousemanager.flowerpot.sow;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

public interface SowHerb {
    void sow(HerbDetail herb);
    void water(HerbDetail herb,double waterMl);
    int getDayOfLife(HerbDetail herb);
}
