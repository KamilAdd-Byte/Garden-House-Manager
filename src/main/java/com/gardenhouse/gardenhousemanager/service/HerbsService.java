package com.gardenhouse.gardenhousemanager.service;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;

import java.util.Collection;
import java.util.List;


public interface HerbsService {
    List<HerbDetail> allHerbs();
    HerbDetail addHerbs(HerbDetail herbDetail);
}
