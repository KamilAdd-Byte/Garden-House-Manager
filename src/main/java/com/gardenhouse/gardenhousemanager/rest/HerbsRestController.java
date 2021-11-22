package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.appconsole.database.DataBaseForHerbs;
import com.gardenhouse.gardenhousemanager.model.HerbDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class HerbsRestController {

    DataBaseForHerbs dataBaseForHerbs = new DataBaseForHerbs();

    @GetMapping("/herbs")
    public ResponseEntity<List<HerbDto>> getAllHerbs(){
        List<HerbDto> herbDtos = dataBaseForHerbs.allHerbs();
        return ResponseEntity.ok().body(herbDtos);
    }
}
