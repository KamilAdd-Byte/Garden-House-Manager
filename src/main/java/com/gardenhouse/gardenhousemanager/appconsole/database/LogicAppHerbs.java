package com.gardenhouse.gardenhousemanager.appconsole.database;

import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.model.HerbDto;

import java.util.List;

/**
 * @author kamillodzinski
 * Klasa tylko wyświetla listę ziół z bazy
 */
public class LogicAppHerbs {
    private final DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();

    public void displayAllHerbsInDataBase() {
        List<HerbDto> herbDtoList = dataBaseForHerbs.allHerbs();
        herbDtoList.forEach(System.out::println);
    }

    public void setDefaultParameters(HerbDto herbDto) {
        herbDto.setDayLife(0);
        herbDto.setName("Default");
        herbDto.setGrowthUp(false);
        herbDto.setDescription("No find");
        herbDto.setWaterConsumptionPerDay(WaterConsumption.LITTLE);

    }

    public HerbDto search(String name) {
        List<HerbDto> herbDtos = dataBaseForHerbs.allHerbs();
        try {
            for (HerbDto herbDto : herbDtos) {
                if (herbDto.getName().contains(name)) {
                    return herbDto;
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        System.out.println("Nie znaleziono: ** " + name + " ** poniżej pierwsze z listy zioło:");
        return herbDtos.get(0);
    }
}
