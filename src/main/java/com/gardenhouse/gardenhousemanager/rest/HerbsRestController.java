package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.model.Herbs;
import com.gardenhouse.gardenhousemanager.service.HerbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HerbsRestController {

    @Autowired
    HerbsService service;

    @GetMapping("/herbs")
    public ResponseEntity<List<Herbs>> getAllHerbs () {
        List<Herbs> herbs = service.allHerbs();
        return ResponseEntity.ok().body(herbs);
    }

    @PostMapping("/add")
    public ResponseEntity<Herbs> addHerbs(@RequestBody Herbs herbs){
        Herbs save = service.addHerbs(herbs);
        return ResponseEntity.ok().body(save);
    }

}
