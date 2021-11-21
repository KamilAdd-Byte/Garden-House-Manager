package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.flowerpot.sow.ActionHerb;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;


/**
 * This is list herbs for angular and console java APP.
 */
@Getter
@Setter
@NoArgsConstructor
public class HerbDetail extends Plant implements ActionHerb {

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

    public HerbDetail(String name, String image) {
        super(name, image);
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
