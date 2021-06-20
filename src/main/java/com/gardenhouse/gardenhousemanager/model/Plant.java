package com.gardenhouse.gardenhousemanager.model;

public class Plant {

    private String name;

    private String image;

    public Plant() {
    }

    public Plant(String name, String image) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
