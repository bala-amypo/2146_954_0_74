package com.example.demo.controller;

import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @Autowired
    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    // Create a new shipment
    @PostMapping
    public ShipmentEntity createShipment(@RequestBody ShipmentEntity shipment) {
        return shipmentService.saveShipment(shipment); // updated method name
    }

    // Get a shipment by ID
    @GetMapping("/{id}")
    public ShipmentEntity getShipment(@PathVariable Long id) {
        return shipmentService.getShipmentById(id); // updated method name
    }

    // Get all shipments
    @GetMapping
    public List<ShipmentEntity> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    // Delete a shipment by ID
    @DeleteMapping("/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}
