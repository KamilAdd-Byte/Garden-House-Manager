package com.gardenhouse.gardenhousemanager.planting;

public enum MethodOfPlanting {
    TRANSFER("Zioło zostało przesadzone. Już rosło."),
    SOW("Zasadzenie zioła od podstaw. Zasianie nasion w doniczce."),
    SEEDLING("Zasadzenie sadzonki");

    private String choice;

    MethodOfPlanting(String choice) {
        this.choice = choice;
    }
}
