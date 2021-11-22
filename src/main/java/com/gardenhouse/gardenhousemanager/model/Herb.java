package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.planting.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.control.daylife.LiveHerbState;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public abstract class Herb extends Plant {

    private Light light;
    private double waterForHerb;
    private LiveHerbState liveHerbState;
    private Wetness wetness;
    private MethodOfPlanting methodOfPlanting;
    private WaterConsumption waterConsumptionPerDay;

    protected Herb(String name, String image, Light light, double waterFoHerb, LiveHerbState liveHerbState, Wetness wetness, MethodOfPlanting methodOfPlanting, WaterConsumption waterConsumptionPerDay) {
        super(name, image);
        this.light = light;
        this.waterForHerb = waterFoHerb;
        this.waterConsumptionPerDay = waterConsumptionPerDay;
        this.liveHerbState = LiveHerbState.PREPARATION;
        this.wetness = wetness;
        this.methodOfPlanting = methodOfPlanting;
    }

    protected Light getLight() {
        return light;
    }

    protected void setLight(Light light) {
        this.light = light;
    }

    public double getWaterConsumption() {
        return waterForHerb;
    }

    public void setWaterConsumption(double waterConsumption) {
        this.waterForHerb = waterConsumption;
    }

    protected LiveHerbState getLiveHerbState() {
        return liveHerbState;
    }

    protected void setLiveHerbState(LiveHerbState liveHerbState) {
        this.liveHerbState = LiveHerbState.PREPARATION;
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
