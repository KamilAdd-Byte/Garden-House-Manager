package com.gardenhouse.gardenhousemanager.temperature;

import lombok.ToString;

@ToString
public enum BasilTemperature {

   TEMPERATUREBASIL(22,25);

    private final float min;
    private final float max;

    /**
     * @param min temperature of growth to Basil
     * @param max temperature of growth to Basil
     */
    BasilTemperature(float min, float max) {
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
