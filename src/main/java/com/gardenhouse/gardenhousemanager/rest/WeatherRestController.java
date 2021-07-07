package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.model.WeatherDto;
import com.gardenhouse.gardenhousemanager.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherRestController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather(){
        return weatherService.getWeather();
    }
}
