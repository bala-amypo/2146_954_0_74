package com.example.demo.service;

import com.example.demo.entity.ShipmentEntity;
import java.util.List;

public interface ShipmentService {
    ShipmentEntity saveShipment(ShipmentEntity shipment);
    List<ShipmentEntity> getAllShipments();
    ShipmentEntity getShipmentById(Long id);
    void deleteShipment(Long id);
}
