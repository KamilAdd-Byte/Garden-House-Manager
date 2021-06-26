package com.gardenhouse.gardenhousemanager.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;

@NoArgsConstructor
@ToString
public class Plant {

    public String name;

    public String image;

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
}
