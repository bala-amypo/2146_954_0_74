package com.example.demo.service.impl;

import com.example.demo.entity.VehicleEntity;
import com.example.demo.repository.VehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl {

    private final VehicleRepository vehicleRepository;

    public ShipmentServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public void checkVehicleCapacity(VehicleEntity vehicle, double shipmentWeight) {
        if(vehicle.getCapacityKg() < shipmentWeight) {
            throw new IllegalArgumentException("Vehicle capacity is less than shipment weight");
        }
    }
}
