package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.*;
import com.gardenhouse.gardenhousemanager.live.LiveHerbState;
import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author kamillodzinski
 */
@ToString
@NoArgsConstructor
@Entity
public class Basil extends Herb {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "description")
    @Size(min = 2,max = 400)
    private final String description = "Bazylię należy posadzić do większej doniczki z otworami na dnie, które zapobiegają gromadzeniu się wody w ziemi oraz umieścić ją w dekoracyjnej osłonce.Roślinę stawiamy w dobrze nasłonecznionym miejscu, najlepiej na parapecie południowego okna.Ziemia w doniczce musi być stale wilgotna. ";

    @Column(name = "temperature")
    @Enumerated(EnumType.STRING)
    private BasilTemperature temperature;

    @Column(name = "light")
    @Enumerated(EnumType.STRING)
    private Light light;

    @Column(name = "waterConsumption")
    private double waterConsumption;

    @Column(name = "liveHerbState")
    @Enumerated(EnumType.STRING)
    private LiveHerbState liveHerbState = LiveHerbState.PREPARATION;

    @Column(name = "wetness")
    @Enumerated(EnumType.STRING)
    private Wetness wetness;

    @Column(name = "method")
    @Enumerated(EnumType.STRING)
    private MethodOfPlanting methodOfPlanting;

    /**
     * @param name it's final name - Basil
     * @param basilImage
     * @param basilLight
     * @param basilWaterConsumption
     * @param basilLiveHerbState
     * @param id basil id
     * @param temperature
     * @param basilWetness
     * @param basilMethodOfPlanting
     */
    public Basil(String name, String basilImage, Light basilLight, double basilWaterConsumption, LiveHerbState basilLiveHerbState,
                 int id, BasilTemperature temperature, Wetness basilWetness, MethodOfPlanting basilMethodOfPlanting) {
        super(name, basilImage, basilLight, basilWaterConsumption, basilLiveHerbState, basilWetness, basilMethodOfPlanting);
        this.id = id;
        this.temperature = temperature;
        this.light = basilLight;
        this.waterConsumption = basilWaterConsumption;
        this.liveHerbState = LiveHerbState.PREPARATION;
        this.wetness = basilWetness;
        this.methodOfPlanting = basilMethodOfPlanting;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public BasilTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(BasilTemperature temperature) {
        this.temperature = temperature;
    }

    @Override
    protected Light getLight() {
        return Light.MEDIUM;
    }

    @Override
    public void setLight(Light light) {
        super.setLight(light);
    }

    @Override
    public double getWaterConsumption() {
        return super.getWaterConsumption();
    }

    @Override
    public void setWaterConsumption(double waterConsumption) {
        super.setWaterConsumption(waterConsumption);
    }

    @Override
    public LiveHerbState getLiveHerbState() {
        return super.getLiveHerbState();
    }

    @Override
    public void setLiveHerbState(LiveHerbState liveHerbState) {
        super.setLiveHerbState(liveHerbState);
    }

    @Override
    public Wetness getWetness() {
        return super.getWetness();
    }

    @Override
    public void setWetness(Wetness wetness) {
        super.setWetness(wetness);
    }

    @Override
    public MethodOfPlanting getMethodOfPlanting() {
        return super.getMethodOfPlanting();
    }

    @Override
    public void setMethodOfPlanting(MethodOfPlanting methodOfPlanting) {
        super.setMethodOfPlanting(methodOfPlanting);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getImage() {
        return super.getImage();
    }

    @Override
    public void setImage(String image) {
        super.setImage(image);
    }


}
