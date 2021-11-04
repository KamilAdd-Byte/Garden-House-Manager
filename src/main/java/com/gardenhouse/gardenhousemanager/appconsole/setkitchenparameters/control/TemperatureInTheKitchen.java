package com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control;

/**
 * This enum set temperature in the user kitchen.
 * @see com.gardenhouse.gardenhousemanager.model.HerbDetail min and max temperature
 */
public enum TemperatureInTheKitchen {
    LOW(15,17),
    AVERAGE(18,22),
    HIGH(23,25),
    EXTRA_HIGH(26,30);

    private final int intervalMin;
    private final int intervalMax;

    TemperatureInTheKitchen(int intervalMin, int intervalMax) {
        this.intervalMin = intervalMin;
        this.intervalMax = intervalMax;
    }
}
