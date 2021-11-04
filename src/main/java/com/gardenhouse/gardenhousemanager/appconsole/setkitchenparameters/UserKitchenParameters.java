package com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters;

import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.setkitchenparameters.control.WetnessForKitchen;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserKitchenParameters {
    private LightForKitchen light;
    private WetnessForKitchen wetness;
    private TemperatureInTheKitchen temperature;

    public UserKitchenParameters(LightForKitchen light, WetnessForKitchen wetness,TemperatureInTheKitchen temperature) {
        this.light = light;
        this.wetness = wetness;
        this.temperature = temperature;
    }

    public UserKitchenParameters() { }

    @Override
    public String toString() {
        return "Parametry kuchni: " + "\n" +
                "oświetlenie: " + light.getDescription() + "\n" +
                "wilgotność: " + wetness.getDescription() + "\n" +
                "temperatura:  min-" +temperature.getIntervalMin() + "  max- " + temperature.getIntervalMax();
    }
}
