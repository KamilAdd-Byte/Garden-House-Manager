package com.gardenhouse.gardenhousemanager.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
public abstract class Plant {

    private String name;

    private String image;

    public Plant(String name, String image) {
        this.name = name;
        this.image = image;
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
        return "** " + name + " ** " + "zdjęcie: " + image;
    }
}
