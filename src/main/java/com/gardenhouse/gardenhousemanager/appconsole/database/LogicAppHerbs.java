package com.gardenhouse.gardenhousemanager.appconsole.database;

import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.model.HerbDetail;
import java.util.List;

/**
 * @author kamillodzinski
 * Klasa tylko wyświetla listę ziół z bazy
 */
public class LogicAppHerbs {
    private final DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();

    public void displayAllHerbsInDataBase() {
        List<HerbDetail> herbDetailList = dataBaseForHerbs.allHerbs();
        herbDetailList.forEach(System.out::println);
    }

    public void setDefaultParameters(HerbDetail herbDetail) {
        herbDetail.setDayLife(0);
        herbDetail.setName("Default");
        herbDetail.setGrowthUp(false);
        herbDetail.setDescription("No find");
        herbDetail.setWaterConsumptionPerDay(WaterConsumption.LITTLE);

    }

    public HerbDetail search(String name) {
        List<HerbDetail> herbDetails = dataBaseForHerbs.allHerbs();
        try {
            for (HerbDetail herbDetail : herbDetails) {
                if (herbDetail.getName().contains(name)) {
                    return herbDetail;
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        System.out.println("Nie znaleziono: ** " + name + " ** poniżej pierwsze z listy zioło:");
        return herbDetails.get(0);
    }
}
