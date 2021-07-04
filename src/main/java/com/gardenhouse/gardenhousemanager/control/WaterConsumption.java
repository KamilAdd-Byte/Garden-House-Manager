package com.gardenhouse.gardenhousemanager.control;

public enum WaterConsumption {
    LITTLE(0.10),
    MEDIUM(0.25),
    BIG(0.50);

    public final double scope;

    /**
     * @param scope Milliliters for plant per day to Basil
     */
    WaterConsumption(double scope) {
        this.scope = scope;
    }
}
