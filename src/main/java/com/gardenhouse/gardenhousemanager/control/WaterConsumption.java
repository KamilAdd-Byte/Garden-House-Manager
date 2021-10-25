package com.gardenhouse.gardenhousemanager.control;

/**
 * @author kamillodzinski
 * @apiNote this is water plant consumption per day
 */
public enum WaterConsumption {
    LITTLE(0.10),
    MEDIUM(0.25),
    BIG(0.50);

    public final double scope;

    /**
     * @param scope Milliliters for per day to plant
     */
    WaterConsumption(double scope) {
        this.scope = scope;
    }
}
