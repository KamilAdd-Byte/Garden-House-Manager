package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveHerbState;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasilTest {

   @Test
   @DisplayName("should have one description on basil herb")
    void getDescription() {
        //given
       Basil basil = createBasil();
       Light light = basil.getLight();
        String description = basil.getDescription();
        //then
        assertNotNull(description);
        assertThat(description).endsWith("wilgotna. ");
        assertThat(light).isEqualTo(Light.MEDIUM);
    }

    @Test
    @DisplayName("should set for basil the live herb state")
    void setLiveServiceOnPreparation() {
        Basil basil = new Basil();

        LiveHerbState liveHerbState = basil.getLiveHerbState();

        assertThat(liveHerbState).as("Create object set Live to PREPARATION").isEqualTo(LiveHerbState.PREPARATION);
    }

    private Basil createBasil() {
        Basil basil = new Basil();
        basil.setWetness(Wetness.OPTIMUM);
        basil.setTemperature(BasilTemperature.TEMPERATUREBASIL);
        basil.setName("My basil");
        basil.setLight(Light.MEDIUM);
        basil.setImage("image.png");
        basil.setLiveHerbState(LiveHerbState.PREPARATION);
        basil.setWaterConsumption(0.34);
        System.out.println(basil);
        return basil;
    }

    @Test
    void getName() {
    }
}
