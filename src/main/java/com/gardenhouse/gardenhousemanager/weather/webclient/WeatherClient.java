package com.gardenhouse.gardenhousemanager.weather.webclient;

import com.gardenhouse.gardenhousemanager.weather.dto.model.OpenWeatherWeatherDto;
import com.gardenhouse.gardenhousemanager.weather.dto.WeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    private static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String API_KEY = "3229abb2a8b89862edf7adfbeb7ab0df";
    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto = restTemplate.getForObject(WEATHER_URL + "weather?q={city}&APPID={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class, city, API_KEY);
        return WeatherDto.builder()
                .temp(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }
}
