package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepo;
    private final UserRepository userRepo;

    public VehicleServiceImpl(VehicleRepository vehicleRepo, UserRepository userRepo) {
        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public VehicleEntity addVehicle(Long userId, VehicleEntity vehicle) {
        UserEntity user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        
        vehicle.setUser(user);
        return vehicleRepo.save(vehicle);
    }
}