package com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.user;

import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.control.LightForKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.control.TemperatureInTheKitchen;
import com.gardenhouse.gardenhousemanager.appconsole.kitchenparameters.control.WetnessForKitchen;
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


    public String displayAllParameters() {
        return "Parametry kuchni: " + "\n" +
                "oświetlenie: " + light.getDescription() + "\n" +
                "wilgotność: " + wetness.getDescription() + "\n" +
                "temperatura:  min-" +temperature.getIntervalMin() + "  max- " + temperature.getIntervalMax();
    }
}
