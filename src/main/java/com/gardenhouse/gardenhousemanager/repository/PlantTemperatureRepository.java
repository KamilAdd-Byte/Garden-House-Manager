package com.gardenhouse.gardenhousemanager.repository;

import com.gardenhouse.gardenhousemanager.control.PlantTemperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantTemperatureRepository extends JpaRepository<PlantTemperature,Integer> {
}
