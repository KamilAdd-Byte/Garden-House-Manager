package com.gardenhouse.gardenhousemanager.weather.dto.model;

import lombok.Getter;

@Getter
public class OpenWeatherMainDto {
    private float temp;
    private int pressure;
    private int humidity;
}
