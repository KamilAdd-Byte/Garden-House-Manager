package com.gardenhouse.gardenhousemanager.flowerpot;

import com.gardenhouse.gardenhousemanager.model.Basil;
import com.gardenhouse.gardenhousemanager.waterplants.WaterPlantsLogic;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import java.awt.*;

@Slf4j
@NoArgsConstructor
@ToString
public class FlowerPotForBasil extends FlowerPot {

    private Basil basil;
    private PrimerForPlants primer;
    private WaterPlantsLogic waterPlantsLogic;

    public FlowerPotForBasil(Basil basil,PotSize potSize, Color color, Material material, PrimerForPlants primer) {
        super(potSize, color, material);
        this.primer = primer;
        this.basil = basil;
    }

    public FlowerPotForBasil(Basil basil) {
        this.basil = basil;
    }
    //V=PI*r^2*h (PI-stała wartość=3,14; r = połowa średnicy do kwadratu, np średnica 20cm to promień r=10cm do kwadratu; h = wysokość doniczki), i żeby wszystkie wartości wyszły nam w litrach należy jednostki pozamieniać na dm (1 dm=10cm)
    //A jeśli nasza doniczka ma różną dolną i górną srednicę to z dwóch tych średnic robimy śrenią arytmetyczną.
    public double amountOfKindOfSoil(PotSize potSize) {
        if (potSize == PotSize.MEDIUM) {
            return 3.14 * Math.pow(1,2) * 3;

        }
        return 0.0;
    }
}
