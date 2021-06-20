package com.gardenhouse.gardenhousemanager.control;

public enum WaterConsumption {
    LITTLE(0.10),
    MEDIUM(0.25),
    BIG(0.50);

    private final double scope;

    /**
     *
     * @param scope Milliliters per day
     */
    WaterConsumption(double scope) {
        this.scope = scope;
    }
}
