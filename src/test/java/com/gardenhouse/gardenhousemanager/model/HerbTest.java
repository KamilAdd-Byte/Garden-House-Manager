package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Temperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class HerbTest {
    @Test
    void shouldCreateFirstHerb(){
        Herb herb = new Herb();
        herb.setName("Liść laurowy");
        herb.setTemperature(Temperature.OPTIMUM);
        herb.setWaterConsumption(WaterConsumption.LITTLE);
        herb.setLight(Light.MEDIUM);
        herb.setLiveService(LiveService.PREPARATION);
        System.out.print(herb);
    }
}
