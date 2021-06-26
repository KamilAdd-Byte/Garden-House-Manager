package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.Herb;
import com.gardenhouse.gardenhousemanager.repository.HerbRepository;
import com.gardenhouse.gardenhousemanager.service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HerbServiceImpl implements HerbService {


    private final HerbRepository herbRepository;

    @Autowired
    public HerbServiceImpl(HerbRepository herbRepository) {
        this.herbRepository = herbRepository;
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
    public Herb updateHerb(Herb herb) {
       Herb update = herbRepository.findById(herb.getHerbId()).orElseThrow(IllegalArgumentException::new);
       return herbRepository.saveAndFlush(update);
    }
}
