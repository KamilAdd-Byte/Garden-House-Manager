package com.gardenhouse.gardenhousemanager.live;

public enum LiveHerbState {
    PREPARATION("Zioło w stanie przygotowania do zasadzenia"),
    PLANTING("Zioło w stanie zasadzenia"),
    PLANT_GROWTH("Zioło rozwijające się, zasadzone"),
    READY_TOO_EAT("Zioło gotowe do zjedzenia");

    private String description;

    LiveHerbState(String description) {
        this.description = description;
    }
}
