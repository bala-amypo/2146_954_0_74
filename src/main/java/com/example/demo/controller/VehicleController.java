package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.VehicleService;
import com.example.demo.entity.VehicleEntity;
import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/{userId}")
    public VehicleEntity addVehicle(
            @PathVariable Long userId,
            @RequestBody VehicleEntity vehicle
    ) {
        return vehicleService.addVehicle(userId, vehicle);
    }

    @GetMapping("/user/{userId}")
    public List<VehicleEntity> getVehicles(@PathVariable Long userId) {
        return vehicleService.getVehiclesByUser(userId);
    }
}
