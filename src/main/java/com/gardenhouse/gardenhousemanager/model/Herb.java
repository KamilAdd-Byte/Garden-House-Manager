package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Herb extends Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String image;

    @Column(name = "description")
    @Size(min = 2,max = 400)
    private String description;


    @Column(name = "temperature")
    @Enumerated(EnumType.STRING)
    private PlantTemperature temperature;

    @Column(name = "light")
    @Enumerated(EnumType.STRING)
    private Light light;

    @Column(name = "waterConsumption")
    private double waterConsumption;

    @Column(name = "liveService")
    @Enumerated(EnumType.STRING)
    private LiveService liveService;

    @Column(name = "wetness")
    @Enumerated(EnumType.STRING)
    private Wetness wetness;

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    private MethodOfPlanting methodOfPlanting;

    public Herb(String name, String image, int id, String name1, String image1, String description, PlantTemperature temperature, Light light, double waterConsumption, LiveService liveService, Wetness wetness, MethodOfPlanting methodOfPlanting) {
        super(name, image);
        this.id = id;
        this.name = name1;
        this.image = image1;
        this.description = description;
        this.temperature = temperature;
        this.light = light;
        this.waterConsumption = waterConsumption;
        this.liveService = liveService;
        this.wetness = wetness;
        this.methodOfPlanting = methodOfPlanting;
    }
}
