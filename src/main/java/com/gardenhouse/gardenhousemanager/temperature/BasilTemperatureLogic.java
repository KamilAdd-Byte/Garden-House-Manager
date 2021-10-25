package com.gardenhouse.gardenhousemanager.temperature;

import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.waterplants.WaterPlantsLogic;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasilTemperatureLogic extends Basil {

    private Basil basil;
    private WaterPlantsLogic waterPlantsLogic;
    private BasilTemperature temperature;

    public BasilTemperatureLogic(Basil basil) {
        this.basil = basil;
    }

    public void temperatureForWater(Basil basil,double temperatureOfHome){
        if (basil.getTemperature().getMin() >= temperatureOfHome){
            log.warn("Temperatura za niska dla prawidłowego rozwoju zioła. Kondycja rośliny ZAGROŻONA!!");
        } else if (basil.getTemperature().getMax() <= temperatureOfHome){
            double scope = basil.getWaterConsumptionPerDay().scope;
            basil.setWaterConsumptionPerDay(WaterConsumption.BIG);
            log.warn("Temperatura w pomieszczeniu '" + temperatureOfHome + "' za wysoka!! " + scope + " ml wody na dzień zwieksza się do " + basil.getWaterConsumptionPerDay().scope);
        } else {
            log.info("Temperatura optymalna zużycie wody " + basil.getWaterConsumptionPerDay().scope + " ml na dzień zmniejsza się do " + WaterConsumption.MEDIUM.scope);
            double scope = basil.getWaterConsumptionPerDay().scope;
            basil.setWaterConsumptionPerDay(WaterConsumption.MEDIUM);
        }
    }
}
