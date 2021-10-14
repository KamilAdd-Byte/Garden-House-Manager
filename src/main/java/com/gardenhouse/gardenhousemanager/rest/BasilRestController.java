//package com.gardenhouse.gardenhousemanager.rest;
//
//import com.gardenhouse.gardenhousemanager.control.Light;
//import com.gardenhouse.gardenhousemanager.model.BasilTemperature;
//import com.gardenhouse.gardenhousemanager.control.Wetness;
//import com.gardenhouse.gardenhousemanager.live.BasilLogicLiveService;
//import com.gardenhouse.gardenhousemanager.model.Basil;
//import com.gardenhouse.gardenhousemanager.service.BasilInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins = "*")
//public class BasilRestController {
//
//    @Autowired
//    private BasilInfoService basilInfoService;
//
//    @Autowired
//    private BasilLogicLiveService logicLiveService;
//
//    @GetMapping("/basil/names")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<String> getName (){
//        String name = basilInfoService.getName();
//        return ResponseEntity.ok().body(name);
//    }
//
//    @GetMapping("/basil/description")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public String getDescription (){
//        return basilInfoService.getDescription();
//    }
//
//    @GetMapping("/basil/temp")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<BasilTemperature> getTemperature(){
//        BasilTemperature temp = basilInfoService.getTemperature();
//        return ResponseEntity.ok().body(temp);
//    }
//    @GetMapping(value = "/basil/light")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<Light> getLight(){
//        Light light = basilInfoService.getLight();
//        return ResponseEntity.ok().body(light);
//    }
////    @GetMapping("/basil/water")
////    @CrossOrigin(origins = "http://localhost:4200")
////    public ResponseEntity<WaterConsumption> getWaterConsumption(){
////        WaterConsumption consumption = basilInfoService.getWaterConsumption();
////        return ResponseEntity.ok().body(consumption);
////    }
//    @GetMapping("/basil/wetness")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<Wetness> getWetness(){
//        Wetness wetness = basilInfoService.getWetness();
//        return ResponseEntity.ok().body(wetness);
//    }
//
//    @GetMapping("/basil/parameters")
//    @CrossOrigin(origins = "http://localhost:4200")
//    public ResponseEntity<Basil> getParameters(){
//        Basil show =  logicLiveService.showParameters();
//        return ResponseEntity.ok().body(show);
//    }
//}
