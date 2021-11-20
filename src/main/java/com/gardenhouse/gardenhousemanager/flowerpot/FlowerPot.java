package com.gardenhouse.gardenhousemanager.flowerpot;

import com.gardenhouse.gardenhousemanager.flowerpot.sow.ActionHerb;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;
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
    private HerbDetail herb;

    public FlowerPot(PotSize potSize, Color color, Material material,HerbDetail herb) {
        this.potSize = potSize;
        this.color = color;
        this.material = material;
        this.herb = herb;
    }

    public FlowerPot(PotSize potSize, Material material,HerbDetail herb) {
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
    public void sow(HerbDetail pot) {

    }

    @Override
    public void water(HerbDetail herb, double waterMl) {

    }

    @Override
    public int getDayOfLife(HerbDetail herb) {
        return 0;
    }
}
