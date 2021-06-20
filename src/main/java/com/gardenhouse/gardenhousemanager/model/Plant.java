package com.gardenhouse.gardenhousemanager.model;

public class Plant {

    private String name;

    public Plant() {
    }

    public Plant(String name) {
        this.name = name;

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
                ", name='" + name + '\'' +
                '}';
    }
}
