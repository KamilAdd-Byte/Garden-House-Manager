package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.WeatherDto;
import com.gardenhouse.gardenhousemanager.service.WeatherService;
import com.gardenhouse.gardenhousemanager.webclient.weather.WeatherClient;
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
