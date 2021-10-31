package com.gardenhouse.gardenhousemanager.control;

public enum Wetness {
    MINIMUM (40,50),
    OPTIMUM(40,60),
    MAXIMUM(70, 90);

    public int minWetness;
    public int maxWetness;

    /**
     * @param minWetness of growth to herb
     * @param maxWetness of growth to herb
     */
    Wetness(int minWetness, int maxWetness) {
        this.minWetness = minWetness;
        this.maxWetness = maxWetness;
    }

    @Override
    public String toString() {
        return "Wetness{" +
                "minWetness=" + minWetness +
                ", maxWetness=" + maxWetness +
                "} " + super.toString();
    }
}
