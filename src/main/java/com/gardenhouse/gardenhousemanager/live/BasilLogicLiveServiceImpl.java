package com.gardenhouse.gardenhousemanager.live;

import com.gardenhouse.gardenhousemanager.control.MethodOfPlanting;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;
import com.gardenhouse.gardenhousemanager.service.BasilService;
import org.springframework.stereotype.Service;

@Service
public class BasilLogicLiveServiceImpl implements BasilLogicLiveService{

    private BasilService basilService;
    private LiveService liveService;
    private Basil basil;

    @Override
    public void sow() {
        //TODO added and create method sow!
    }

    @Override
    public Basil showParameters() {
        return new Basil();
    }

    @Override
    public void waterHerbs() {

    }

    @Override
    public void choiceMethodOfPlanting() {
       //TODO implementation method planting Basil!
    }
}
