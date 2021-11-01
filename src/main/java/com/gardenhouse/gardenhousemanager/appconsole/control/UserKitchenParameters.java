package com.gardenhouse.gardenhousemanager.appconsole.control;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserKitchenParameters {
    private LightForKitchen light;
    private WetnessForKitchen wetness;

    public UserKitchenParameters(LightForKitchen light, WetnessForKitchen wetness) {
        this.light = light;
        this.wetness = wetness;

    }
}
