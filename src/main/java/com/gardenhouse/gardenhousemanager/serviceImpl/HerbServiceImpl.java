package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.model.Herb;
import com.gardenhouse.gardenhousemanager.repository.HerbRepository;
import com.gardenhouse.gardenhousemanager.repository.PlantTemperatureRepository;
import com.gardenhouse.gardenhousemanager.service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HerbServiceImpl implements HerbService {


    private final HerbRepository herbRepository;
    private PlantTemperatureRepository temperatureRepository;

    @Autowired
    public HerbServiceImpl(HerbRepository herbRepository, PlantTemperatureRepository temperatureRepository) {
        this.herbRepository = herbRepository;
        this.temperatureRepository = temperatureRepository;
    }

    @Override
    public List<Herb> getAllHerbs() {
        return herbRepository.findAll();
    }

    @Override
    public Herb addHerb(Herb herb) {
        return herbRepository.save(herb);
    }

    @Override
    public Herb findById(int id) {
        return herbRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public void deleteHerb(int id) {
        try {
            Herb remove = this.herbRepository.getById(id);
            herbRepository.delete(remove);
        }catch (IllegalArgumentException e){
            e.getStackTrace();
        }
    }

    @Override
    public Herb updateHerb(int id) {
       Herb update = herbRepository.findById(id).orElseThrow(IllegalArgumentException::new);
       return herbRepository.save(update);
    }
}
