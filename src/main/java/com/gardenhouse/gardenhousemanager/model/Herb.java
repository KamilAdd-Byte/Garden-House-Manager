package com.gardenhouse.gardenhousemanager.model;

import com.gardenhouse.gardenhousemanager.control.Light;
import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import com.gardenhouse.gardenhousemanager.control.WaterConsumption;
import com.gardenhouse.gardenhousemanager.control.Wetness;
import com.gardenhouse.gardenhousemanager.live.LiveService;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class Herb extends Plant{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int herbId;

   @Column(name = "description")
   @Size(min = 2,max = 300)
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


   private Herb(String name, String image, String description, PlantTemperature temperature,
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
      String result = "Nazwa: " + super.getName();
      result = getString(result);
      return result;
   }

   private String getString(String result) {
      result += "url " + super.getImage();
      result += " Opis: " + description;
      result += " Zdjęcie: " + getImage();
      result += " Temperatura do rozwoju: " + temperature;
      result += " Światło: " + light;
      result += " Dzienne zapotrzebowanie na wodę: " + waterConsumption;
      result += " Wilgotność: " + wetness;
      result += " Cykl życia: " + liveService;
      return result;
   }

   public static class HerbBuilder {
      private String name;
      private String image;
      private String description;
      private PlantTemperature temperature;
      private Light light;
      private WaterConsumption waterConsumption;
      private LiveService liveService;
      private Wetness wetness;

      public HerbBuilder setName(String name) {
         this.name = name;
         return this;
      }

      public HerbBuilder setImage(String image) {
         this.image = image;
         return this;
      }

      public HerbBuilder setDescription(String description) {
         this.description = description;
         return this;
      }

      public HerbBuilder setTemperature(PlantTemperature temperature) {
         this.temperature = temperature;
         return this;
      }

      public HerbBuilder setLight(Light light) {
         this.light = light;
         return this;
      }

      public HerbBuilder setWaterConsumption(WaterConsumption waterConsumption) {
         this.waterConsumption = waterConsumption;
         return this;
      }

      public HerbBuilder setLiveService(LiveService liveService) {
         this.liveService = liveService;
         return this;
      }

      public HerbBuilder setWetness(Wetness wetness) {
         this.wetness = wetness;
         return this;
      }

      public Herb createHerb() {
         return new Herb(name, image, description, temperature, light, waterConsumption, liveService, wetness);
      }
   }
}
