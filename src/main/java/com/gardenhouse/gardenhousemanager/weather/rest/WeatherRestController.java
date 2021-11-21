package com.gardenhouse.gardenhousemanager.weather.rest;

import com.gardenhouse.gardenhousemanager.weather.dto.WeatherDto;
import com.gardenhouse.gardenhousemanager.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherRestController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<WeatherDto> getWeather(){
        return ResponseEntity.ok().body(weatherService.getWeather());
    }
}
