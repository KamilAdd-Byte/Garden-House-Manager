package com.gardenhouse.gardenhousemanager.repository;

import com.gardenhouse.gardenhousemanager.model.Herbs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HerbsRepository extends JpaRepository<Herbs,Integer> {
}
