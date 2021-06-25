package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.Herb;
import com.gardenhouse.gardenhousemanager.repository.HerbRepository;
import com.gardenhouse.gardenhousemanager.service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HerbServiceImpl implements HerbService {

    @Autowired
    private final HerbRepository herbRepository;

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
        return this.herbRepository.getById(id);
    }

    @Override
    public void deleteHerb(int id) {
        Herb remove = this.herbRepository.getById(id);
        herbRepository.delete(remove);
    }
}
