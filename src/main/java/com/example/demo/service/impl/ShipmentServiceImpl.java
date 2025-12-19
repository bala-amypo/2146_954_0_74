package com.example.demo.service.impl;

import com.example.demo.entity.ShipmentEntity;
import com.example.demo.repository.ShipmentRepository;
import com.example.demo.service.ShipmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public ShipmentEntity saveShipment(ShipmentEntity shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public List<ShipmentEntity> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public ShipmentEntity getShipmentById(Long id) {
        Optional<ShipmentEntity> shipment = shipmentRepository.findById(id);
        return shipment.orElse(null);
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }
}
