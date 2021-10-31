package com.gardenhouse.gardenhousemanager.flowerpot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.awt.*;

/**
 * 'Doniczka' Flowerpot it's abstract class to inheritance.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FlowerPot {
    private PotSize potSize;
    private Color color;
    private Material material;


    public FlowerPot(PotSize potSize, Color color, Material material) {
        this.potSize = potSize;
        this.color = color;
        this.material = material;

    }

    public FlowerPot(PotSize potSize, Material material) {
        this.potSize = potSize;
        this.material = material;
    }
}
