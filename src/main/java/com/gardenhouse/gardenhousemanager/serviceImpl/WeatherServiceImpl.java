package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.WeatherDto;
import com.gardenhouse.gardenhousemanager.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public WeatherDto getWeather() {
       String response =  restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=poznan&APPID=3229abb2a8b89862edf7adfbeb7ab0df&units=metric&lang=pl",String.class);
       log.info(response);
        return null;
    }
}
