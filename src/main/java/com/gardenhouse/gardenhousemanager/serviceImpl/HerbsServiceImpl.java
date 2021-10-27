package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.Herbs;
import com.gardenhouse.gardenhousemanager.repository.HerbsRepository;
import com.gardenhouse.gardenhousemanager.service.HerbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HerbsServiceImpl implements HerbsService {

    @Autowired
    HerbsRepository repository;

    @Override
    public List<Herbs> allHerbs() {
        return this.repository.findAll();
    }

    @Override
    public Herbs addHerbs(Herbs herbs) {
        if (herbs!=null){
            return this.repository.save(herbs);
        }
        return null;
    }
}
