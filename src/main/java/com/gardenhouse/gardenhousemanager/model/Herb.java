package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Herb extends Plant{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int herbId;

   @Column(name = "description")
   private String description;

   @OneToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "temp_id")
   private PlantTemperature temperature;

   @Column(name = "light")
   @Enumerated(EnumType.ORDINAL)
   private Light light;

   @Column(name = "waterConsumption")
   @Enumerated(EnumType.ORDINAL)
   private WaterConsumption waterConsumption;

   @Column(name = "liveService")
   @Enumerated(EnumType.ORDINAL)
   private LiveService liveService;

   @Column(name = "wetness")
   @Enumerated(EnumType.ORDINAL)
   private Wetness wetness;


   public Herb(String name, String image, String description, PlantTemperature temperature,
               Light light, WaterConsumption waterConsumption, LiveService liveService,Wetness wetness) {
      super(name, image);
      this.description = description;
      this.temperature = temperature;
      this.light = light;
      this.waterConsumption = waterConsumption;
      this.liveService = liveService;
      this.wetness = wetness;
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

   public PlantTemperature getTemperature() {
      return temperature;
   }

   public void setTemperature(PlantTemperature temperature) {
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
      liveService = LiveService.PREPARATION;
      return liveService;
   }
   private void setLiveService(LiveService liveService) {
      this.liveService = liveService;
   }

   public Wetness getWetness() {
      return wetness;
   }

   public void setWetness(Wetness wetness) {
      this.wetness = wetness;
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
      result += " Wilgotność: " + wetness;
      result += " Cykl życia: " + liveService;
      return result;
   }
}
