package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public abstract class Herb extends Plant {

    private Light light;
    private double waterConsumption;
    private LiveService liveService;
    private Wetness wetness;
    private MethodOfPlanting methodOfPlanting;

    protected Herb(String name, String image, Light light, double waterConsumption, LiveService liveService, Wetness wetness, MethodOfPlanting methodOfPlanting) {
        super(name, image);
        this.light = light;
        this.waterConsumption = waterConsumption;
        this.liveService = liveService;
        this.wetness = wetness;
        this.methodOfPlanting = methodOfPlanting;
    }

    protected Light getLight() {
        return light;
    }

    protected void setLight(Light light) {
        this.light = light;
    }

    protected double getWaterConsumption() {
        return waterConsumption;
    }

    protected void setWaterConsumption(double waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    protected LiveService getLiveService() {
        return liveService;
    }

    protected void setLiveService(LiveService liveService) {
        this.liveService = liveService;
    }

    protected Wetness getWetness() {
        return wetness;
    }

    protected void setWetness(Wetness wetness) {
        this.wetness = wetness;
    }

    protected MethodOfPlanting getMethodOfPlanting() {
        return methodOfPlanting;
    }

    protected void setMethodOfPlanting(MethodOfPlanting methodOfPlanting) {
        this.methodOfPlanting = methodOfPlanting;
    }
}
