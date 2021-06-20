package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Temperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;

public class Herb extends Plant{

   private String description;
   private Temperature temparature;
   private Light light;
   private WaterConsumption waterConsumption;
}
