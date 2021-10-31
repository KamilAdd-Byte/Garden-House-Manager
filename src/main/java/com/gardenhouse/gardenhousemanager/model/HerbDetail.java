package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * This is list herbs for angular and console java APP.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class HerbDetail extends Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHerb;

    private int dayLife;

    @Enumerated(EnumType.STRING)
    private WaterConsumption waterConsumptionPerDay;

    @Enumerated(EnumType.STRING)
    private Light light;

    @Enumerated(EnumType.STRING)
    private Wetness wetness;

    @Size(min = 5,max = 200)
    private String description;

    private double minTemperature;

    private double maxTemperature;

    private boolean growthUp;

    private String monthToSow;

    private Date dateOfSow = new Date();

    public HerbDetail(String name, String image, int dayLife, WaterConsumption waterConsumptionPerDay, Light light,
                       Wetness wetness, String description, double minTemperature, double maxTemperature,boolean growthUp,
                      String monthToSow) {
        super(name, image);
        this.dayLife = dayLife;
        this.waterConsumptionPerDay = waterConsumptionPerDay;
        this.light = light;
        this.wetness = wetness;
        this.description = description;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.growthUp = growthUp;
        this.monthToSow = monthToSow;
        this.dateOfSow = new Date();
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
            System.out.println("Zioło nie jest posadzone");
        return null;
    }

    public void setDateOfSow(Date dateOfSow) {
        this.dateOfSow = dateOfSow;
    }

    @Override
    public String toString() {
        String result = getName() + " img: " + getImage() + "\n";
        result = getWaterConsumptionForDay(result);
        return result;
    }

    private String getWaterConsumptionForDay(String result) {
        result+= "zapotrzebowanie dzienne na wodę: "+ waterConsumptionPerDay.scope + " litra dziennie"+ "\n";
        result+= "preferowane światło: "+light.getDescription() + "\n";
        result+= "wilgotność MIN i MAX: "+ wetness.minWetness + " min " + wetness.maxWetness+ " max "+"\n";
        result+= "opis: "+ description + "\n";
        result+= "minimalna temperatura dla: "  + minTemperature + "\n";
        result+= "maksymalna temperatura dla: " + maxTemperature + "\n";
        result+= "preferowany miesiąc wysiewu: " + monthToSow + "\n";
        return result;
    }

    public String toStringSowHerb() {
       String result = getName() + " img: " + getImage() + "\n";
        result+= "id zioła: "+ idHerb + "\n";
        result+= "dni życia: "+ dayLife + "\n";
        result = getWaterConsumptionForDay(result);
        result+= "data zasadzenia: " + getDateOfSow() + "\n";
        result+= "------------------------------------------------------------------------------------------";
        return result;
    }
}
