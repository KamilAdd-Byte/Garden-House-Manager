package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.Temperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Herb extends Plant{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int herbId;

   private String description;

   private Temperature temperature;

   private Light light;

   private WaterConsumption waterConsumption;

   private LiveService liveService;

   public Herb() {
   }

   public Herb(String name, String image, String description, Temperature temperature,
               Light light, WaterConsumption waterConsumption, LiveService liveService) {
      super(name, image);
      this.description = description;
      this.temperature = temperature;
      this.light = light;
      this.waterConsumption = waterConsumption;
      this.liveService = liveService;
   }

   public int getHerbId() {
      return herbId;
   }

   private void setHerbId(int herbId) {
      this.herbId = herbId;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Temperature getTemperature() {
      return temperature;
   }

   public void setTemperature(Temperature temperature) {
      this.temperature = temperature;
   }

   public Light getLight() {
      return light;
   }

   public void setLight(Light light) {
      this.light = light;
   }

   public WaterConsumption getWaterConsumption() {
      return waterConsumption;
   }

   public void setWaterConsumption(WaterConsumption waterConsumption) {
      this.waterConsumption = waterConsumption;
   }

   public LiveService getLiveService() {
      return liveService;
   }

   public void setLiveService(LiveService liveService) {
      this.liveService = liveService;
   }

   @Override
   public String toString() {
      String result = "Nazwa: " + getName();
      result = getString(result);
      return result;
   }

   private String getString(String result) {
      result += " Opis: " + description;
      result += " Zdjęcie: " + getImage();
      result += " Temperatura do rozwoju: " + temperature;
      result += " Światło: " + light;
      result += " Dzienne zapotrzebowanie na wodę: " + waterConsumption;
      result += " Cykl życia: " + liveService;
      return result;
   }
}
