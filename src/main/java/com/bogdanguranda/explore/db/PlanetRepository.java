package com.bogdanguranda.explore.db;

import com.bogdanguranda.explore.model.Planet;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called planetRepository

public interface PlanetRepository extends CrudRepository<Planet, Integer> {

}