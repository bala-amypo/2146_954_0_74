package com.example.demo.controller;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Create a new vehicle
    @PostMapping
    public VehicleEntity addVehicle(@RequestBody VehicleEntity vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    // Get all vehicles
    @GetMapping
    public List<VehicleEntity> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Get a vehicle by ID
    @GetMapping("/{id}")
    public VehicleEntity getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    // Update a vehicle
    @PutMapping("/{id}")
    public VehicleEntity updateVehicle(@PathVariable Long id, @RequestBody VehicleEntity updatedVehicle) {
        VehicleEntity existingVehicle = vehicleService.getVehicleById(id);
        if (existingVehicle != null) {
            existingVehicle.setName(updatedVehicle.getName());
            existingVehicle.setCapacity(updatedVehicle.getCapacity());
            existingVehicle.setUserId(updatedVehicle.getUserId());
            return vehicleService.saveVehicle(existingVehicle);
        }
        return null; // or throw an exception
    }

    // Delete a vehicle
    @DeleteMapping("/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "Vehicle with ID " + id + " deleted successfully.";
    }
}
