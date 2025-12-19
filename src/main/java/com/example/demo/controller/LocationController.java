package com.example.demo.controller;

import com.example.demo.entity.LocationEntity;
import com.example.demo.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // Create a new location
    @PostMapping
    public LocationEntity addLocation(@RequestBody LocationEntity location) {
        return locationService.saveLocation(location);
    }

    // Get all locations
    @GetMapping
    public List<LocationEntity> getAllLocations() {
        return locationService.getAllLocations();
    }

    // Get a location by ID
    @GetMapping("/{id}")
    public LocationEntity getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    // Update a location
    @PutMapping("/{id}")
    public LocationEntity updateLocation(@PathVariable Long id, @RequestBody LocationEntity updatedLocation) {
        LocationEntity existingLocation = locationService.getLocationById(id);
        if (existingLocation != null) {
            existingLocation.setName(updatedLocation.getName());
            existingLocation.setLatitude(updatedLocation.getLatitude());
            existingLocation.setLongitude(updatedLocation.getLongitude());
            return locationService.saveLocation(existingLocation);
        }
        return null; // or throw an exception
    }

    // Delete a location
    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "Location with ID " + id + " deleted successfully.";
    }
}
