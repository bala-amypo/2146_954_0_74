package com.example.demo.service;

import com.example.demo.entity.VehicleEntity;

public interface VehicleService {
    VehicleEntity addVehicle(Long userId, VehicleEntity vehicle);
}