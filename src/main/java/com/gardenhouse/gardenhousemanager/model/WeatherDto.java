package com.gardenhouse.gardenhousemanager.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WeatherDto {
    private float temp;
    private int pressure;
    private int humidity;
    private float windSpeed;
}
