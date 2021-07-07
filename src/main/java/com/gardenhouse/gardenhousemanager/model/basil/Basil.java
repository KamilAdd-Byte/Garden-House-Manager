package com.gardenhouse.gardenhousemanager.model.basil;

import com.gardenhouse.gardenhousemanager.control.*;
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
    @Enumerated(EnumType.STRING)
    private PlantTemperature temperature;

    @Column(name = "light")
    @Enumerated(EnumType.STRING)
    private Light light;

    @Column(name = "waterConsumption")
    private double waterConsumption;

    @Column(name = "liveService")
    @Enumerated(EnumType.STRING)
    private LiveService liveService;

    @Column(name = "wetness")
    @Enumerated(EnumType.STRING)
    private Wetness wetness;

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    private MethodOfPlanting methodOfPlanting;

    public Basil(String name, String image, String description, PlantTemperature temperature,
                 Light light, double waterConsumption, LiveService liveService,
                 Wetness wetness, MethodOfPlanting methodOfPlanting) {
        this.temperature = PlantTemperature.TEMPERATUREBASIL;
        this.wetness = Wetness.MINIMUM;
        this.light = Light.MEDIUM;
        this.waterConsumption = waterConsumption;
        this.liveService = liveService;
        this.methodOfPlanting = methodOfPlanting;
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

    public PlantTemperature getTemperature() {
        temperature = PlantTemperature.TEMPERATUREBASIL;
        return temperature;
    }

    private void setTemperature(PlantTemperature temperature) {
        this.temperature = temperature;
    }

    public Light getLight() {
        light = Light.MEDIUM;
        return light;
    }

    private void setLight(Light light) {
        this.light = light;
    }

    public double getWaterConsumption() {
        waterConsumption = 0.0;
        return waterConsumption;
    }

    public void setWaterConsumption(double waterConsumption) {
        this.waterConsumption = waterConsumption;
    }

    public LiveService getLiveService() {
        liveService = LiveService.PREPARATION;
        return liveService;
    }

    private void setLiveService(LiveService liveService) {
        this.liveService = liveService;
    }

    public Wetness getWetness() {
        wetness = Wetness.OPTIMUM;
        return wetness;
    }

    private void setWetness(Wetness wetness) {
        this.wetness = wetness;
    }

    public MethodOfPlanting getMethodOfPlanting() {
        return methodOfPlanting;
    }

    public void setMethodOfPlanting(MethodOfPlanting methodOfPlanting) {
        this.methodOfPlanting = methodOfPlanting;
    }

    public static class BasilBuilder {
        private String name;
        private String image;
        private String description;
        private PlantTemperature temperature;
        private Light light;
        private double waterConsumption;
        private LiveService liveService;
        private Wetness wetness;
        private MethodOfPlanting methodOfPlanting;

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

        public BasilBuilder setWaterConsumption(double waterConsumption) {
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

        public BasilBuilder setMethodOfPlanting(MethodOfPlanting methodOfPlanting){
            this.methodOfPlanting = methodOfPlanting;
            return this;
        }
        public Basil createBasil() {
            return new Basil(name, image, description, temperature, light, waterConsumption,
                    liveService, wetness,methodOfPlanting);
        }
    }
}
