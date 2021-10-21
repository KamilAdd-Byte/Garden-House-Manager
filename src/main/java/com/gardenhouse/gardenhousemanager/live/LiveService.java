package com.gardenhouse.gardenhousemanager.live;

public enum LiveService {
    PREPARATION("Zioło w stanie przygotowania do zasadzenia"),
    PLANTING("Zioło w stanie zaszadzenia"),
    PLANTGROWTH("Zioło rozwijające się, zasadzone"),
    READYTOOEAT("Zioło gotowe do zjedzenia");

    private String description;

    LiveService(String description) {
        this.description = description;
    }
}
