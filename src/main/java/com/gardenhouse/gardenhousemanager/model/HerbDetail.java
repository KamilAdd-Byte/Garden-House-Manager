package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.flowerpot.FlowerPot;
import com.gardenhouse.gardenhousemanager.flowerpot.Material;
import com.gardenhouse.gardenhousemanager.flowerpot.PotSize;
import com.gardenhouse.gardenhousemanager.flowerpot.sow.SowHerb;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.awt.*;
import java.time.LocalDate;
import java.util.*;


/**
 * This is list herbs for angular and console java APP.
 */
@Getter
@Setter
@NoArgsConstructor
public class HerbDetail extends Plant implements SowHerb {

    public static class FlowerPot {
        private PotSize potSize;
        private Color color;
        private Material material;
        private HerbDetail herb;

        public FlowerPot(PotSize potSize, Color color, Material material, HerbDetail herb) {
            this.potSize = potSize;
            this.color = color;
            this.material = material;
            this.herb = herb;
        }
        public FlowerPot(PotSize potSize, Material material, HerbDetail herb) {
            this.potSize = potSize;
            this.material = material;
            this.herb = herb;
        }

        public PotSize getPotSize() {
            return potSize;
        }

        public void setPotSize(PotSize potSize) {
            this.potSize = potSize;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Material getMaterial() {
            return material;
        }

        public void setMaterial(Material material) {
            this.material = material;
        }

        public HerbDetail getHerb() {
            return herb;
        }

        public void setHerb(HerbDetail herb) {
            this.herb = herb;
        }

        /**
         * @param size set size enum for flowerpot
         * @param color set color awt for flowerpot (optional)
         * @param material set material enum for flowerpot
         * @return new flowerpot
         */
        public FlowerPot createNewPot(PotSize size,Color color,Material material,HerbDetail herb){
            setPotSize(size);
            setColor(color);
            setMaterial(material);
            return new FlowerPot(size,color,material,herb);
        }

        public FlowerPot() {
        }

        @Override
        public String toString() {
            return "FlowerPot{" +
                    "potSize=" + potSize +
                    ", color=" + color +
                    ", material=" + material +
                    ", herb=" + herb +
                    '}';
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHerb;

    private int dayLife;

    @Enumerated(EnumType.STRING)
    private WaterConsumption waterConsumptionPerDay;

    private double water;

    @Enumerated(EnumType.STRING)
    private Light light;

    @Size(min = 5,max = 200)
    private String description;

    private double minTemperature;

    private double maxTemperature;

    private boolean growthUp;

    private String monthToSow;

    private Date dateOfSow;

    private FlowerPot pot;

    // Instance for FlowerPot
    public FlowerPot instance(){
        return new FlowerPot();
    }

    /**It's constructor for no sow herbs
     * @param name nazwa zioła
     * @param image miejsce na zdjęcie dla zioła
     * @param dayLife gdy 'growthUp=true' dni życia naliczaja się
     * @param waterConsumptionPerDay przybliżona wartość spozywania wody przez dane zioło w skali dnia
     * @param light przybliżona wartość nasłonecznienia dla prawidłowego rozwoju zioła
     * @param description opis zioła
     * @param minTemperature min temperatura dla prawidłowego wzrostu zioła
     * @param maxTemperature max temperatura dla prawidłowego wzrostu zioła
     * @param growthUp wartość tru, gdy zasiejemy zioło
     * @param monthToSow preferowany miesiąc zasiania zioła
     */
    public HerbDetail(String name, String image, int dayLife, WaterConsumption waterConsumptionPerDay, Light light,
                      String description, double minTemperature, double maxTemperature,boolean growthUp,
                      String monthToSow) {
        super(name, image);
        this.dayLife = dayLife;
        this.waterConsumptionPerDay = waterConsumptionPerDay;
        this.light = light;
        this.description = description;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.growthUp = growthUp;
        this.monthToSow = monthToSow;
        this.dateOfSow = new Date();

    }

    /**It's constructor for SOW herbs
     * @param name nazwa zioła
     * @param image miejsce na zdjęcie dla zioła
     * @param dayLife gdy growthUp=true dni życia naliczaja się
     * @param waterConsumptionPerDay przybliżona wartość spozywania wody przez dane zioło w skali dnia
     * @param light przybliżona wartość nasłonecznienia dla prawidłowego rozwoju zioła
     * @param description opis zioła
     * @param minTemperature min temperatura dla prawidłowego wzrostu zioła
     * @param maxTemperature max temperatura dla prawidłowego wzrostu zioła
     * @param growthUp wartość tru, gdy zasiejemy zioło
     * @param monthToSow preferowany miesiąc zasiania zioła
     * @param pot parametry doniczki, w której zasiane jest zioło
     */
    public HerbDetail(String name, String image, int dayLife, WaterConsumption waterConsumptionPerDay, Light light,
                      String description, double minTemperature, double maxTemperature,boolean growthUp,
                      String monthToSow,FlowerPot pot) {
        super(name, image);
        this.dayLife = dayLife;
        this.waterConsumptionPerDay = waterConsumptionPerDay;
        this.light = light;
        this.description = description;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.growthUp = growthUp;
        this.monthToSow = monthToSow;
        this.dateOfSow = new Date();
        this.pot = pot;
    }

    public String getMonthToSow() {
        return monthToSow;
    }

    public void setMonthToSow(String monthToSow) {
        this.monthToSow = monthToSow;
    }

    public Date getDateOfSow() {
        if (growthUp==true){
            return dateOfSow;
        }else
            System.out.println("INFO: Zioło nie jest posadzone");
        return null;
    }

    public void setDateOfSow(Date dateOfSow) {
        this.dateOfSow = dateOfSow;
    }

    @Override
    public void sow(FlowerPot pot) {
        setGrowthUp(true);
        setDateOfSow(new Date());
        setPot(pot);
    }

    @Override
    public void water(HerbDetail herb,double waterMl) {
        PotSize potSize = this.pot.getPotSize();
        if (waterMl<=potSize.getMl()){
            System.out.println("Roślina podlana: " + waterMl);
            herb.setWater(waterMl);
        }else if (waterMl>=potSize.getMl()){
            System.out.println("Nie mozna podlać wartością: " + waterMl +". Grozi przelaniem rośliny");
        }
    }

    @Override
    public int getDayOfLife(HerbDetail herb) {
        Date dateOfSow = herb.getDateOfSow();
        int dateOfSowDay = dateOfSow.getDay();
        LocalDate now = LocalDate.now();
        int dayOfMonth = now.getDayOfMonth();
        int result = dayOfMonth - dateOfSowDay;
        herb.setIdHerb(result);
        return result;
    }

    @Override
    public String toString() {
        String result = "\n\n** "+getName() + " ** "+ " zdjęcie: " + getImage() + "\n";
        result = getWaterConsumptionForDay(result);
        return result;
    }

    private String getWaterConsumptionForDay(String result) {
        result+= "zapotrzebowanie dzienne na wodę: "+ waterConsumptionPerDay.scope + " litra dziennie"+ "\n";
        result+= "stan nawodnienia: " + water + "\n";
        result+= "preferowane światło: "+ light.getDescription() + "\n";
        result+= "opis: "+ description + "\n";
        result+= "minimalna temperatura dla: " + getName() + " " + minTemperature + "\n";
        result+= "maksymalna temperatura dla: " + getName() + " " + maxTemperature + "\n";
        result+= "preferowany miesiąc wysiewu: " + monthToSow + "\n";
        return result;
    }

    public String toStringSowHerb() {
        String result = "------------------------------------------------------------------------------------------";
        result = "** "+getName() + " ** "+ " zdjęcie: " + getImage() + "\n";
        result+= "id zioła: "+ idHerb + "\n";
        result+= "dni życia: "+ dayLife + "\n";
        result = getWaterConsumptionForDay(result);
        result+= "data zasadzenia: " + getDateOfSow() + "\n\n\n";
        result+= "------------------------------------------------------------------------------------------";
        return result;
    }
}
