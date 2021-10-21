package com.gardenhouse.gardenhousemanager.weather.service;

import com.gardenhouse.gardenhousemanager.weather.dto.WeatherDto;
import com.gardenhouse.gardenhousemanager.weather.webclient.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherClient weatherClient;

    @Override
    public WeatherDto getWeather() {
        return weatherClient.getWeatherForCity("poznan");
    }
}
