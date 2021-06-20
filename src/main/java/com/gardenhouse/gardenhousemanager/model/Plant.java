package com.gardenhouse.gardenhousemanager.model;

public class Plant {
    private int plantId;
    private String name;


    public Plant() {
    }

    public Plant(String name, int plantId) {
        this.name = name;
        this.plantId = plantId;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "plantId=" + plantId +
                ", name='" + name + '\'' +
                '}';
    }
}
