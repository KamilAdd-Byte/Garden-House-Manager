package com.gardenhouse.gardenhousemanager.waterplants;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.control.daylife.LiveHerbState;
import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.planting.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WaterPlantsLogicTest {

    @Test
    @DisplayName("should not water plant for negative value of water")
    void shouldNotWaterPlantForNegativeValueOfWater() {
        //given
        Basil basil = createBasil();
        WaterPlantsLogic waterPlantsLogic = new WaterPlantsLogic(basil);

        //when
        double v = waterPlantsLogic.waterPlant(-0.22, basil);
        waterPlantsLogic.setWaterConsumption(0.12);
        double waterConsumption = waterPlantsLogic.getWaterConsumption();
        double v1 = basil.getWaterConsumptionPerDay().scope - waterConsumption;
        System.out.println("Po jednym dniu: " + v1);

        //then
        assertNotNull(basil);
        assertEquals(WaterConsumption.MEDIUM, waterPlantsLogic.getWaterConsumptionPerDay());
        assertThat(basil.getWaterForBasil()).isEqualTo(0.00);
        assertThat(basil.getWetness()).isEqualTo(Wetness.OPTIMUM);
    }

    private Basil createBasil() {
        Basil basil = new Basil();
        basil.setWetness(Wetness.OPTIMUM);
        basil.setTemperature(BasilTemperature.TEMPERATUREBASIL);
        basil.setName("My basil");
        basil.setLight(Light.MEDIUM);
        basil.setImage("image.png");
        basil.setLiveHerbState(LiveHerbState.PREPARATION);
        basil.setWaterConsumption(0.00);
        basil.setMethodOfPlanting(MethodOfPlanting.SEEDLING);
        return basil;
    }
}
