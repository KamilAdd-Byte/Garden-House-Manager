package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This is list herbs for angular
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class HerbDetail extends Plant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHerb;

    private String name;
    private int dayLife;

    @Enumerated(EnumType.STRING)
    private WaterConsumption waterConsumptionPerDay;

    @Enumerated(EnumType.STRING)
    private Light light;

    @Enumerated(EnumType.STRING)
    private Wetness wetness;

    @Size(min = 5,max = 200)
    private String description;

    private double minTemperature;

    private double maxTemperature;
}
