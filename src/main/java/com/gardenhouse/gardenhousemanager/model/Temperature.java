package com.gardenhouse.gardenhousemanager.model;

public enum Temperature {
    TOOCOOLD(14),
    MIN(17),
    OPTIMUM(23),
    MAXIMUM(27),
    TOOHOT(28);

    public double scope;

    Temperature(double scope) {
        this.scope = scope;
    }
}
