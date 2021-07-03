package com.gardenhouse.gardenhousemanager.model.basil;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import com.gardenhouse.gardenhousemanager.model.Plant;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Size;

@ToString
@NoArgsConstructor
@Entity
public class Basil extends Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private final String name = "Basil";

    private final String image = "url";

    @Column(name = "description")
    @Size(min = 2,max = 400)
    private final String description = "Bazylię należy posadzić do większej doniczki z otworami na dnie, " +
            "które zapobiegają gromadzeniu się wody w ziemi oraz umieścić ją w dekoracyjnej osłonce. " +
            "Roślinę stawiamy w dobrze nasłonecznionym miejscu, najlepiej na parapecie południowego okna." +
            " Ziemia w doniczce musi być stale wilgotna. ";


    @Column(name = "temperature")
    @Enumerated(EnumType.ORDINAL)
    private PlantTemperature temperature;

    @Column(name = "light")
    @Enumerated(EnumType.ORDINAL)
    private Light light;

    @Column(name = "waterConsumption")
    @Enumerated(EnumType.ORDINAL)
    private WaterConsumption waterConsumption;

    @Column(name = "liveService")
    @Enumerated(EnumType.ORDINAL)
    private LiveService liveService;

    @Column(name = "wetness")
    @Enumerated(EnumType.ORDINAL)
    private Wetness wetness;

    public Basil(String name, String image, String description, PlantTemperature temperature,
                 Light light, WaterConsumption waterConsumption, LiveService liveService,
                 Wetness wetness) {
        this.temperature = PlantTemperature.TEMPERATUREBASIL;
        this.wetness = Wetness.MINIMUM;
        this.light = Light.MEDIUM;
        this.waterConsumption = WaterConsumption.MEDIUM;
        this.liveService = liveService;
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    private PlantTemperature getTemperature() {
        return temperature;
    }

    private void setTemperature(PlantTemperature temperature) {
        this.temperature = temperature;
    }

    private Light getLight() {
        return light;
    }

    private void setLight(Light light) {
        this.light = light;
    }

    private WaterConsumption getWaterConsumption() {
        return waterConsumption;
    }

    private void setWaterConsumption(WaterConsumption waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    private LiveService getLiveService() {
        return liveService;
    }

    private void setLiveService(LiveService liveService) {
        this.liveService = liveService;
    }

    private Wetness getWetness() {
        return wetness;
    }

    private void setWetness(Wetness wetness) {
        this.wetness = wetness;
    }

    public static class BasilBuilder {
        private String name;
        private String image;
        private String description;
        private PlantTemperature temperature;
        private Light light;
        private WaterConsumption waterConsumption;
        private LiveService liveService;
        private Wetness wetness;

        public BasilBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BasilBuilder setImage(String image) {
            this.image = image;
            return this;
        }

        public BasilBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BasilBuilder setTemperature(PlantTemperature temperature) {
            this.temperature = temperature;
            return this;
        }

        public BasilBuilder setLight(Light light) {
            this.light = light;
            return this;
        }

        public BasilBuilder setWaterConsumption(WaterConsumption waterConsumption) {
            this.waterConsumption = waterConsumption;
            return this;
        }

        public BasilBuilder setLiveService(LiveService liveService) {
            this.liveService = liveService;
            return this;
        }

        public BasilBuilder setWetness(Wetness wetness) {
            this.wetness = wetness;
            return this;
        }

        public Basil createBasil() {
            return new Basil(name, image, description, temperature, light, waterConsumption,
                    liveService, wetness);
        }
    }
}
