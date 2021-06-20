package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.model.Herb;
import com.gardenhouse.gardenhousemanager.service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/herbs")
public class HerbRestController {
    @Autowired
    private HerbService herbService;

    @GetMapping("/herbs")
    public ResponseEntity<List<Herb>> getAllHerbs(){
        List<Herb> herbs = herbService.getAllHerbs();
        return ResponseEntity.ok().body(herbs);
    }
    @PostMapping("/add")
    public ResponseEntity<Herb> addHerbs(@RequestBody Herb herb) {
        Herb addHerb = herbService.addHerb(herb);
        return ResponseEntity.ok().body(addHerb);
    }
}
