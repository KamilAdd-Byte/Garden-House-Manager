package com.gardenhouse.gardenhousemanager.control;

public enum MethodOfPlanting {
    TRANSFER(false),
    SOW(false),
    SEEDLING(false);

    private boolean choice;

    MethodOfPlanting(boolean choice) {
        this.choice = choice;
    }
}
