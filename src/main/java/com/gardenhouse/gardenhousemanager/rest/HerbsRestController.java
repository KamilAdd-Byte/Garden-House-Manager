package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.model.HerbDetail;
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
    public ResponseEntity<List<HerbDetail>> getAllHerbs () {
        List<HerbDetail> herbs = service.allHerbs();
        return ResponseEntity.ok().body(herbs);
    }

    @PostMapping("/add")
    public ResponseEntity<HerbDetail> addHerbs(@RequestBody HerbDetail herbDetail){
        HerbDetail save = service.addHerbs(herbDetail);
        return ResponseEntity.ok().body(save);
    }

}
