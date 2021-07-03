package com.gardenhouse.gardenhousemanager.rest;

import com.gardenhouse.gardenhousemanager.service.BasilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasilRestController {

    @Autowired
    private BasilService basilService;

    @GetMapping("/basil/description")
    public String getDescription (){
        return basilService.getDescription();
    }
}
