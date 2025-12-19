package com.example.demo.service.impl;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleEntity saveVehicle(VehicleEntity vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleEntity> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public VehicleEntity getVehicleById(Long id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public List<VehicleEntity> getVehiclesByUserId(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }
}
