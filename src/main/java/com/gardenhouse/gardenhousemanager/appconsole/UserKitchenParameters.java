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
    private Light light;
    private Wetness wetness;

    public UserKitchenParameters(Light light, Wetness wetness) {
        this.light = light;
        this.wetness = wetness;
    }
}
