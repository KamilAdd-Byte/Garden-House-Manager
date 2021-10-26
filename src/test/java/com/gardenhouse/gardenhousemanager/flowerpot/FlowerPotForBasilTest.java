package com.gardenhouse.gardenhousemanager.flowerpot;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveHerbState;
import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.planting.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlowerPotForBasilTest {

    @Test
    void amountOfKindOfSoil() {
        //given
        Basil basil = createBasil();
        FlowerPotForBasil pot = new FlowerPotForBasil(basil);
        pot.setPotSize(PotSize.MEDIUM);
        pot.setColor(Color.BLUE);
        pot.setMaterial(Material.PLASTIC);

        double q = pot.amountOfSubsoil(PotSize.EXTRA_SMALL);
        System.out.println("Litrów ziemi w doniczce: " + q);
        double v = pot.amountOfSubsoilWithUserParameters(30, 20, 10);
        System.out.println(v + " parameters");
        float i = pot.convertCmToDm(20);
        System.out.println(i);

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
        return basil;
    }
}
