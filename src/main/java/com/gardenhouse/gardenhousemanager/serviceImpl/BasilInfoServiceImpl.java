//package com.gardenhouse.gardenhousemanager.serviceImpl;
//
//import com.gardenhouse.gardenhousemanager.control.*;
//import com.gardenhouse.gardenhousemanager.model.Basil;
//import com.gardenhouse.gardenhousemanager.temperature.BasilTemperature;
//import com.gardenhouse.gardenhousemanager.repository.BasilRepository;
//import com.gardenhouse.gardenhousemanager.service.BasilInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BasilInfoServiceImpl implements BasilInfoService {
//
//    private final BasilRepository repository;
//
//    @Autowired
//    public BasilInfoServiceImpl(final BasilRepository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public Basil get(int id) {
//        return this.repository.getById(id);
//    }
//
//    @Override
//    public String getName() {
//        Basil basil = new Basil();
//        return basil.getName();
//    }
//
//    @Override
//    public String getDescription() {
//        Basil basil = new Basil();
//        return basil.getDescription();
//    }
//
//    @Override
//    public BasilTemperature getTemperature() {
//       Basil basil = new Basil();
//       return basil.getTemperature();
//    }
//
//    @Override
//    public Wetness getWetness() {
//        Basil basil = new Basil();
//        return basil.getWetness();
//    }
//
//    @Override
//    public Light getLight() {
//        Basil basil = new Basil();
//        return basil.getLight();
//    }
//
//    @Override
//    public MethodOfPlanting choice() {
//        //TODO Create choice method planting Basil
//        return null;
//    }
//}
