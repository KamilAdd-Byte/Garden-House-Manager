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

    /**
     * @param potSize Size of pot for enum type
     * @apiNote counts the volume of the pot converted to liters of substrate
     * @return V=PI*r^2*h
     */
    public int amountOfSubsoil(PotSize potSize) {
        // TODO: 27.10.2021 ! 
        return 0;
    }

    /**
     * @param depth głębokość doniczki
     * @param upDiameter średnica górnego otworu doniczki
     * @param downDiameter średnica dna doniczki
     * @return zwraca przybliżona wartość ilości ziemi, które mieszcza się w danej doniczce (wynik w litrach)
     */
    public double amountOfSubsoilWithUserParameters (double depth,double upDiameter, double downDiameter) {
        double arithmeticAverage = (upDiameter + downDiameter) / 2;
        return (Math.PI * Math.pow(arithmeticAverage/10,2) * depth/10) / 10;
    }

    /**
     * @apiNote 1 dm = 10 cm; 1 dm3 = 1 litr
     * @param centimeters unit of measure.
     * @return decimeters unit of measure.
     */
    public float convertCentimetersToDecimeters (float centimeters){
        return centimeters / 10;
    }

    //1 dm = 10 cm ,3dm 3dm
    //1 dm3= 1 litr
    //1 litr = 1000 cm3
    //1 cm3 = 0,000001 m3
}
