package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.model.Herb;

import java.util.List;

public interface HerbService {

    List<Herb> getAllHerbs();

    Herb addHerb(Herb herb);
}
