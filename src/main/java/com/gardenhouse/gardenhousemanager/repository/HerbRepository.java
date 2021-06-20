package com.gardenhouse.gardenhousemanager.repository;

import com.gardenhouse.gardenhousemanager.model.Herb;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HerbRepository extends CrudRepository<Herb,Integer> {
}
