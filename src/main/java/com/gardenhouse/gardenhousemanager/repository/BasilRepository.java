package com.gardenhouse.gardenhousemanager.repository;

import com.gardenhouse.gardenhousemanager.model.Basil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BasilRepository extends JpaRepository<Basil,Integer> {
}
