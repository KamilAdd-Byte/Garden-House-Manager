package com.gardenhouse.gardenhousemanager.serviceImpl;

import com.gardenhouse.gardenhousemanager.model.basil.Basil;
import com.gardenhouse.gardenhousemanager.service.BasilService;
import org.springframework.stereotype.Service;

@Service
public class BasilServiceImpl implements BasilService {

    private Basil basil;

    @Override
    public String getDescription() {
        return basil.getDescription();
    }
}
