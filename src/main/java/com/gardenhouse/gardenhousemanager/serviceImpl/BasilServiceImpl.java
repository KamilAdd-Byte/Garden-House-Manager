package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;
import com.gardenhouse.gardenhousemanager.repository.BasilRepository;
import com.gardenhouse.gardenhousemanager.service.BasilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasilServiceImpl implements BasilService {

    private final BasilRepository repository;

    @Autowired
    public BasilServiceImpl(final BasilRepository repository) {
        this.repository = repository;
    }

    @Override
    public Basil get(int id) {
        return this.repository.getById(id);
    }

    @Override
    public String getName() {
        Basil basil = new Basil();
        return basil.getName();
    }

    @Override
    public String getDescription() {
        Basil basil = new Basil();
        return basil.getDescription();
    }

    @Override
    public PlantTemperature getTemperature() {
       Basil basil = new Basil();
       return basil.getTemperature();
    }

    @Override
    public Wetness getWetness() {
        Basil basil = new Basil();
        return basil.getWetness();
    }

    @Override
    public WaterConsumption getWaterConsumption() {
        Basil basil = new Basil();
        return basil.getWaterConsumption();
    }

    @Override
    public Light getLight() {
        Basil basil = new Basil();
        return basil.getLight();
    }
}
