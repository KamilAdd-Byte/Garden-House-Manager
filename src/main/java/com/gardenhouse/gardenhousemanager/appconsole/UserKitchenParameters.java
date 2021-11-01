package com.gardenhouse.gardenhousemanager.appconsole;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Wetness;
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
    private Wetness wetness;

    public UserKitchenParameters(LightForKitchen light, Wetness wetness) {
        this.light = light;
        this.wetness = wetness;
    }
}
