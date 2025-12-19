package com.example.demo.controller;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<VehicleEntity> addVehicle(@PathVariable Long userId, @RequestBody VehicleEntity vehicle) {
        VehicleEntity savedVehicle = vehicleService.addVehicle(userId, vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<VehicleEntity>> getVehiclesByUser(@PathVariable Long userId) {
        List<VehicleEntity> vehicles = vehicleService.getVehiclesByUser(userId);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleEntity> getVehicle(@PathVariable Long id) {
        VehicleEntity vehicle = vehicleService.findById(id);
        return ResponseEntity.ok(vehicle);
    }
}
