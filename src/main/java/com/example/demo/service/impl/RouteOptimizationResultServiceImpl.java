package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.entity.ShipmentEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RouteOptimizationServiceImpl implements RouteOptimizationService {

    private final RouteOptimizationResultRepository resultRepository;
    private final ShipmentRepository shipmentRepository;
    private final Random random = new Random();

    public RouteOptimizationServiceImpl(RouteOptimizationResultRepository resultRepository,
                                        ShipmentRepository shipmentRepository) {
        this.resultRepository = resultRepository;
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public RouteOptimizationResultEntity optimizeRoute(Long shipmentId) {
        ShipmentEntity shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Shipment not found"));

        RouteOptimizationResultEntity result = new RouteOptimizationResultEntity();
        result.setShipment(shipment);
        result.setOptimizedDistanceKm(50 + random.nextDouble() * 100); // dummy distance
        result.setEstimatedFuelUsageL(5 + random.nextDouble() * 10);    // dummy fuel

        return resultRepository.save(result);
    }

    @Override
    public RouteOptimizationResultEntity getResult(Long resultId) {
        return resultRepository.findById(resultId)
                .orElseThrow(() -> new ResourceNotFoundException("Result not found"));
    }
}
