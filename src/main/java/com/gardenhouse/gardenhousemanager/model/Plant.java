package com.gardenhouse.gardenhousemanager.model;

import lombok.NoArgsConstructor;
import javax.persistence.Id;

@NoArgsConstructor
public class Plant {

    private String name;

    private String image;


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

}
