package com.example.demo.service;

import com.example.demo.entity.VehicleEntity;
import java.util.List;

public interface VehicleService {
    VehicleEntity saveVehicle(VehicleEntity vehicle);
    List<VehicleEntity> getAllVehicles();
    VehicleEntity getVehicleById(Long id);
    void deleteVehicle(Long id);
    List<VehicleEntity> getVehiclesByUserId(Long userId);
}
