package com.gardenhouse.gardenhousemanager.model.vo;

import lombok.Value;

@Value
public class Water {
    double waterForHerb;

    public Water(double waterForHerb) {
      this.waterForHerb = waterForHerb;
    }

    public boolean isNotZero() {
        return waterForHerb != 0;
    }
}
