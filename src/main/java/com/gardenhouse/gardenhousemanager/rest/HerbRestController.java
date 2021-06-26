package com.gardenhouse.gardenhousemanager.rest;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.model.Herb;
import com.gardenhouse.gardenhousemanager.repository.PlantTemperatureRepository;
import com.gardenhouse.gardenhousemanager.service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/herb")
public class HerbRestController {
    @Autowired
    private HerbService herbService;
    @Autowired
    private PlantTemperatureRepository temperatureRepository;
    
    @GetMapping("/herbs")
    public ResponseEntity<List<Herb>> getAllHerbs() {
        List<Herb> herbs = herbService.getAllHerbs();
        return ResponseEntity.ok().body(herbs);
    }

    @GetMapping(value = "/herb/{id}")
    public ResponseEntity<Herb> getOneHerb(@PathVariable("id") int id) {
        Herb getHerb = herbService.findById(id);
        return ResponseEntity.ok().body(getHerb);
    }

    @PostMapping(value = "/herb/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Herb> updateHerb(@PathVariable("id") int id, @RequestBody Herb update) {
        Herb herb = getHerb(id, update);
        herbService.updateHerb(id);
        return ResponseEntity.ok().body(herb);
    }

    private Herb getHerb(int id, Herb update) {
        Herb herb = herbService.findById(id);
        herb.setName(update.name);
        herb.setImage(update.image);
        herb.setDescription(update.getDescription());
        herb.setWaterConsumption(update.getWaterConsumption());
        herb.setLight(update.getLight());
        herb.setWetness(update.getWetness());
        return herb;
    }

    @PostMapping("/herb/add")
    public ResponseEntity<Herb> addHerbs(@RequestBody Herb herb) {
        Herb addHerb = herbService.addHerb(herb);
        return ResponseEntity.ok().body(addHerb);
    }

    @DeleteMapping("/herb/{id}")
    public ResponseEntity<Herb> deleteHerb(@PathVariable("id") int id) {
        herbService.deleteHerb(id);
        return ResponseEntity.noContent().build();
    }
}
