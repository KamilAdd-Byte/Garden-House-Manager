package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.planting.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveHerbState;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
        Basil basil = createBasil();

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
        basil.setMethodOfPlanting(MethodOfPlanting.SEEDLING);
        System.out.println(basil);
        return basil;
    }

    @Test
    @DisplayName("should set control fields for basil")
    void shouldSetControlFieldsForBasil() {
       //given
       Basil basil = createBasil();

       //when
       basil.setLight(Light.LITTLE);
       basil.setLiveHerbState(LiveHerbState.PLANTING);

        LiveHerbState changeLiveHerbState = basil.getLiveHerbState();

        basil.setLight(Light.HARD);
        //then
        assertNotNull(basil);
        assertThat(basil.getLiveHerbState()).isEqualTo(changeLiveHerbState);
        assertThat(basil.getLight()).isEqualTo(Light.HARD);
    }

    @Test
    @DisplayName("should set control fields for basil")
    void shouldBasilChangeDaysOfLifeWhenTheDaysGoBy() {
        //given
        Basil basil = createBasil();
        Date date = new Date();
        int date1 = date.getDate();
        System.out.println(date1);
        //then
        assertNotNull(basil);
        assertThat(basil.getLight()).isEqualTo(Light.MEDIUM);
    }
}
