package com.gardenhouse.gardenhousemanager.live;

import com.gardenhouse.gardenhousemanager.model.WeatherDto;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;
import com.gardenhouse.gardenhousemanager.service.WeatherService;
import com.gardenhouse.gardenhousemanager.webclient.weather.WeatherClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class BasilLogicLiveServiceImplTest {

    @Autowired
    private BasilLogicLiveService basilLogicLiveService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherClient weatherClient;
    @Test
    void showParameters() {
    }

    @Test
    void waterIt() {
        Basil basil = new Basil();
        String name = basil.getName();
        double water = basil.getWaterConsumption();
        System.out.println("Aktualny stan: " + name + " poziom nawodnienia: " + water);
        Basil basil1 = basilLogicLiveService.waterIt(0.50);
        System.out.println(basil1);
    }
    @Test
    void checkTemperature(){
    }
}
