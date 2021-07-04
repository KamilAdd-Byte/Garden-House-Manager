package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.live.BasilLogicLiveService;
import com.gardenhouse.gardenhousemanager.live.BasilLogicLiveServiceImpl;
import com.gardenhouse.gardenhousemanager.model.basil.Basil;
import com.gardenhouse.gardenhousemanager.service.BasilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class BasilRestController {

    @Autowired
    private BasilService basilService;

    @Autowired
    private BasilLogicLiveService logicLiveService;

    @GetMapping("/basil/name")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getName (){
        return basilService.getName();
    }

    @GetMapping("/basil/description")
    @CrossOrigin(origins = "http://localhost:4200")
    public String getDescription (){
        return basilService.getDescription();
    }

    @GetMapping("/basil/temp")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<PlantTemperature> getTemperature(){
        PlantTemperature temp = basilService.getTemperature();
        return ResponseEntity.ok().body(temp);
    }
    @GetMapping("/basil/light")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Light> getLight(){
        Light light = basilService.getLight();
        return ResponseEntity.ok().body(light);
    }
    @GetMapping("/basil/water")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<WaterConsumption> getWaterConsumption(){
        WaterConsumption consumption = basilService.getWaterConsumption();
        return ResponseEntity.ok().body(consumption);
    }
    @GetMapping("/basil/parameters")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Basil> getParameters(){
        Basil show =  logicLiveService.showParameters();
        return ResponseEntity.ok().body(show);
    }

}
