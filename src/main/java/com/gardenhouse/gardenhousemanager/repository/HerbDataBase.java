package com.gardenhouse.gardenhousemanager.repository;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import com.gardenhouse.gardenhousemanager.model.Herb;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HerbDataBase{

    public List<Herb> findAll() {
        List<Herb> allHerbs = new ArrayList<>();
        //TODO added herbs
        allHerbs.add(new Herb.HerbBuilder().setName("Liść laurowy").setImage("something url").setDescription("Liść laurowy wraz z zielem angielskim tworzy duet, " +
                "który jest niezbędny do przygotowywania dań na ciepło – zup, sosów czy gulaszy. " +
                "Najczęściej decydujemy się na gotową suszoną postać przyprawy dostępną na sklepowych półkach." +
                " Liście laurowe możemy również uprawiać na parapecie. ")
                .setTemperature(new PlantTemperature(-15.80, 25.06, 5.5)).setLight(Light.LITTLE).setWaterConsumption(WaterConsumption.LITTLE).setLiveService(LiveService.PREPARATION).setWetness(Wetness.MINIMUM).createHerb());

        allHerbs.add(new Herb.HerbBuilder().setName("Bazylia").setImage("something url")
                .setDescription("Bazylię należy posadzić do większej doniczki z " +
                        "otworami na dnie, które zapobiegają gromadzeniu się wody w ziemi oraz umieścić ją w " +
                        "dekoracyjnej osłonce. Roślinę stawiamy w dobrze nasłonecznionym miejscu, najlepiej na " +
                        "parapecie południowego okna. Ziemia w doniczce musi być stale wilgotna, dlatego należy " +
                        "regularnie sprawdzać poziom nawodnienia i uzupełniać wodę. Praktycznym rozwiązaniem jest " +
                        "zakup specjalnej doniczki do uprawy bazylii z inteligentnym systemem samonawadniającym, " +
                        "który wyręcza nas z obowiązku systematycznego podlewania.")
                .setTemperature(new PlantTemperature(15.80, 25.06, 5.5))
                .setLight(Light.MEDIUM).setWaterConsumption(WaterConsumption.MEDIUM)
                .setLiveService(LiveService.PREPARATION)
                .setWetness(Wetness.OPTIMUM).createHerb());

        return allHerbs;
    }
}
