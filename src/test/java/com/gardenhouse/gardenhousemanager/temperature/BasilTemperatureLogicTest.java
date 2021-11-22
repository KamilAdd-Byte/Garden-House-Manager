package com.gardenhouse.gardenhousemanager.temperature;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.control.daylife.LiveHerbState;
import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.planting.MethodOfPlanting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BasilTemperatureLogicTest {

    @Test
    @DisplayName("should change temperature has an impact to water consumption per day for basil")
    void shouldChangeTemperatureHasAnImpactToWaterConsumptionPerDay() {
        Basil basil = createBasil();
        BasilTemperatureLogic temperatureLogic = new BasilTemperatureLogic(basil);
        temperatureLogic.temperatureForWater(basil,33);
        //when
        temperatureLogic.temperatureForWater(basil,24);

        //then
        assertThat(basil.getWaterConsumptionPerDay()).isEqualTo(WaterConsumption.MEDIUM);
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
        basil.setWaterConsumptionPerDay(WaterConsumption.MEDIUM);
        return basil;
    }
}
