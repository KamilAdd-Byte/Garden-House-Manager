package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HerbTest {
    @Test
    void shouldCreateFirstHerb(){
        Herb herb = new Herb();
        herb.setName("Liść laurowy");
        herb.setDescription("Zioła wytrzymałe na ciepłe dni");
//        herb.setTemperature(Temperature.OPTIMUM);
        herb.setWaterConsumption(WaterConsumption.LITTLE);
        herb.setLight(Light.MEDIUM);
        System.out.print(herb);
    }
}
