package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.model.Herbs;
import org.springframework.stereotype.Service;
import java.util.List;


public interface HerbsService {
    List<Herbs> allHerbs();
    Herbs addHerbs(Herbs herbs);
}
