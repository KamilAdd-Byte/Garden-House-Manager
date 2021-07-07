package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.WeatherDto;
import com.gardenhouse.gardenhousemanager.service.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "3229abb2a8b89862edf7adfbeb7ab0df";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public WeatherDto getWeather() {
        String response = getWeatherForCity("poznan");
        log.info(response);
        return null;
    }

    private String getWeatherForCity(String city) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&APPID={apiKey}&units=metric&lang=pl",
                String.class, city, API_KEY);
    }
}
