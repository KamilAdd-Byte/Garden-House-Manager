package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;
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
    public List<HerbDetail> allHerbs() {
        return this.repository.findAll();
    }

    @Override
    public HerbDetail addHerbs(HerbDetail herbDetail) {
        if (herbDetail !=null){
            return this.repository.save(herbDetail);
        }
        return null;
    }
}
