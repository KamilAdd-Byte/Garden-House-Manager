package com.gardenhouse.gardenhousemanager.control;

import lombok.ToString;

@ToString
public enum PlantTemperature {

   TEMPERATUREBASIL(22,25);

    private final double min;
    private final double max;

    PlantTemperature(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }
}
