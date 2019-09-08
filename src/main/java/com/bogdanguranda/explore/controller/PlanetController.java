package com.bogdanguranda.explore.controller;

import com.bogdanguranda.explore.db.PlanetRepository;
import com.bogdanguranda.explore.model.Planet;
import com.bogdanguranda.explore.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
@CrossOrigin
@RequestMapping(path="/planets")
public class PlanetController {

    @Autowired
    private PlanetRepository planetRepository;

    @GetMapping(value = "")
    public Iterable<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPlanet(@PathVariable("id") Integer id) {
        Planet planet = planetRepository.findOne(id);
        if (planet == null) {
            return new ResponseEntity<>("Planet doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(planet, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<String> createPlanet(@Valid @RequestBody Planet planet) {
        planetRepository.save(planet);
        return new ResponseEntity<>("Planet was created successfully", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> updatePlanet(@RequestBody Planet planet) {
        Planet planetFound = planetRepository.findOne(planet.getId());
        if (planetFound == null) {
            return new ResponseEntity<>("Planet doesn't exist", HttpStatus.NOT_FOUND);
        }

        if (Arrays.binarySearch(Status.values(), planet.getStatus()) >= 0) {
            planetFound.setStatus(planet.getStatus());
        }

        if (!StringUtils.isEmpty(planet.getDescription())) {
            planetFound.setDescription(planet.getDescription());
        }

        planetRepository.save(planetFound);

        return new ResponseEntity<>("Planet was updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlanet(@PathVariable("id") Integer id) {
        planetRepository.delete(id);
        return new ResponseEntity<>("Planet was deleted successfully", HttpStatus.OK);
    }
}
