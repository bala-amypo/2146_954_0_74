package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.VehicleService;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.VehicleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final UserRepository userRepository;

    public VehicleServiceImpl(
            VehicleRepository vehicleRepository,
            UserRepository userRepository
    ) {
        this.vehicleRepository = vehicleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public VehicleEntity addVehicle(Long userId, VehicleEntity vehicle) {
        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );

        vehicle.setUser(user);
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleEntity> getVehiclesByUser(Long userId) {
        return vehicleRepository.findByUserId(userId);
    }

    @Override
    public VehicleEntity findById(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle not found")
                );
    }
}
