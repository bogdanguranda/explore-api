package com.bogdanguranda.explore.controller;

import java.util.HashMap;
import java.util.Map;

import com.bogdanguranda.explore.model.Planet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanetController {
    private static Map<String, Planet> planetsRepo = new HashMap<>();

    static {
        Planet alderaan = new Planet();
        alderaan.setName("Alderaan");
        planetsRepo.put(alderaan.getName(), alderaan);

        Planet gama7 = new Planet();
        gama7.setName("Gama 7");
        planetsRepo.put(gama7.getName(), gama7);
    }

    @RequestMapping(value = "/planets", method = RequestMethod.POST)
    public ResponseEntity<Object> createPlanet(@RequestBody Planet planet) {
        planetsRepo.put(planet.getName(), planet);
        return new ResponseEntity<>("Planet was created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/planets")
    public ResponseEntity<Object> getAllPlanets() {
        return new ResponseEntity<>(planetsRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/planets/{name}")
    public ResponseEntity<Object> getPlanet(@PathVariable("name") String name) {
        return new ResponseEntity<>(planetsRepo.get(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/planets/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePlanet(@PathVariable("name") String name, @RequestBody Planet planet) {
        planetsRepo.put(name, planet);
        return new ResponseEntity<>("Planet was updated successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/planets/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePlanet(@PathVariable("name") String name) {
        planetsRepo.remove(name);
        return new ResponseEntity<>("Planet was deleted successfully", HttpStatus.OK);
    }
}
