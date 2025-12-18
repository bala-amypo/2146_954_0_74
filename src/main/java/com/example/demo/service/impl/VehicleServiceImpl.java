VehicleServiceImpl.java

package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.entity.User;
import com.example.demo.entity.Vehicle;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepo;
    private final UserRepository userRepo;

    public VehicleServiceImpl(VehicleRepository vehicleRepo,
                              UserRepository userRepo) {
        this.vehicleRepo = vehicleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Vehicle addVehicle(Long userId, Vehicle vehicle) {

        if (vehicle.getCapacityKg() <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vehicle.setUser(user);
        return vehicleRepo.save(vehicle);
    }
}