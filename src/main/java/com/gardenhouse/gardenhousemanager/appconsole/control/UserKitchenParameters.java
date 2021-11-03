package com.gardenhouse.gardenhousemanager.appconsole.control;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserKitchenParameters {
    private LightForKitchen light;
    private WetnessForKitchen wetness;

    public UserKitchenParameters(LightForKitchen light, WetnessForKitchen wetness) {
        this.light = light;
        this.wetness = wetness;

    }

    @Override
    public String toString() {
        return "Parametry kuchni: " + "\n" +
                "oświetlenie: " + light.getDescription() + "\n" +
                "wilgotność: " + wetness.getDescription();
    }
}
