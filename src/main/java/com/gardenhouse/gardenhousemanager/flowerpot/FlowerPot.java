package com.gardenhouse.gardenhousemanager.flowerpot;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.awt.*;

/**
 * 'Doniczka' Flowerpot it's class to inheritance.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FlowerPot {
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
}
