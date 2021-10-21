package com.gardenhouse.gardenhousemanager.live;

public enum LiveHerbState {
    PREPARATION("Zioło w stanie przygotowania do zasadzenia"),
    PLANTING("Zioło w stanie zaszadzenia"),
    PLANTGROWTH("Zioło rozwijające się, zasadzone"),
    READYTOOEAT("Zioło gotowe do zjedzenia");

    private String description;

    LiveHerbState(String description) {
        this.description = description;
    }
}
