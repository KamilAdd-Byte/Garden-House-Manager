package com.gardenhouse.gardenhousemanager.waterplants;

import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.model.Basil;

import java.util.logging.Logger;

public class WaterPlantsLogic extends Basil{
    private Logger logger = Logger.getLogger(WaterPlantsLogic.class.getName());
    private Basil basil;
    private WaterConsumption waterConsumption;


    public WaterPlantsLogic(Basil basil) {
        this.basil = basil;
    }

    @Override
    public double getWaterConsumption() {
        return super.getWaterConsumption();
    }

    @Override
    public void setWaterConsumption(double water) {
        double actualWaterBasilConsumption = 0;
        if (this.basil==null){
            throw new NullPointerException();
        } else if (water <= 0){
            this.basil.setWaterConsumption(basil.getWaterConsumption());
            logger.info("Nie można podlać bazyli wartością: " + water);
        } else {
            this.basil.setWaterConsumption(water);
            double waterConsumption = this.basil.getWaterConsumption();
            actualWaterBasilConsumption += waterConsumption;
            double consumptionPerDayAfterWaterBasil = this.basil.getWaterConsumptionPerDay().scope - actualWaterBasilConsumption;
            logger.info("Po jednym dniu wody w naczyniu: " + consumptionPerDayAfterWaterBasil);
        }
        super.setWaterConsumption(actualWaterBasilConsumption);
    }

    public double waterPlant (double water, Basil basil){
        double actualWaterBasilConsumption = 0;
        if (basil==null){
            throw new NullPointerException();
        } else if (water <= 0){
            basil.setWaterConsumption(basil.getWaterConsumption());
            logger.info("Nie można podlać bazyli wartością: " + water);
         } else {
            basil.setWaterConsumption(water);
            double waterConsumption = basil.getWaterConsumption();
            return actualWaterBasilConsumption + waterConsumption;
        }
        return actualWaterBasilConsumption;
    }
}
