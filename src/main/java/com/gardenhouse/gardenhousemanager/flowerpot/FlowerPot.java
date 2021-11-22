package com.gardenhouse.gardenhousemanager.flowerpot;

import com.gardenhouse.gardenhousemanager.control.daylife.Condition;
import com.gardenhouse.gardenhousemanager.flowerpot.parameters.Material;
import com.gardenhouse.gardenhousemanager.flowerpot.parameters.PotSize;
import com.gardenhouse.gardenhousemanager.flowerpot.sow.ActionHerb;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.awt.*;
import java.time.format.DateTimeFormatter;

/**
 * 'Doniczka' Flowerpot it's class to inheritance.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FlowerPot implements ActionHerb {

    /**
     * Internal class for FlowerPot
     */
    static class WaterSystem {
        private double waterHerb;// konkretna wartość ml podlania rosliny
        private boolean waterFull;//pelne nawodnienia
        private boolean waterEmpty;//pusto nawodnienia
        private boolean resetWaterForDay;

        public double getWaterHerb() {
            return waterHerb;
        }

        public void setWaterHerb(double waterHerb) {
            this.waterHerb = waterHerb;
        }

        public boolean isWaterFull() {
            return waterFull;
        }

        public void setWaterFull(boolean waterFull) {
            this.waterFull = waterFull;
        }

        public boolean isWaterEmpty() {
            return waterEmpty;
        }

        public void setWaterEmpty(boolean waterEmpty) {
            this.waterEmpty = waterEmpty;
        }

        public boolean isResetWaterForDay() {
            return resetWaterForDay;
        }

        public void setResetWaterForDay(boolean resetWaterForDay) {
            this.resetWaterForDay = resetWaterForDay;
        }

        @Override
        public String toString() {
            return "Nawodnienie +" + waterHerb + " ml";
        }
    }

    private static final DateTimeFormatter formatWaterDay = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private WaterSystem waterSystem = new WaterSystem();
    private PotSize potSize;
    private Color color;
    private Material material;
    private HerbDto herb;

    public FlowerPot(PotSize potSize, Color color, Material material, HerbDto herb) {
        this.potSize = potSize;
        this.color = color;
        this.material = material;
        this.herb = herb;
    }

    public FlowerPot(PotSize potSize, Material material, HerbDto herb) {
        this.potSize = potSize;
        this.material = material;
        this.herb = herb;
    }
    public FlowerPot(PotSize potSize, Color color, Material material) {
        this.potSize = potSize;
        this.color = color;
        this.material = material;
    }

    @Override
    public void sow(HerbDto pot) {
        // TODO: 20.11.2021 Implementation this method. Create class logic switch and structure
    }

    @Override
    public void water(HerbDto herb, double waterMl) {
      // TODO: 20.11.2021 Implementation this method.
    }

    @Override
    public int getDayOfLife(HerbDto herb) {
        // TODO: 20.11.2021 Implementation this method.
        return 0;
    }

    @Override
    public void conditionDisplay(Condition condition, HerbDto herb, FlowerPot pot) {
        // TODO: 22.11.2021 !! 
    }
}
