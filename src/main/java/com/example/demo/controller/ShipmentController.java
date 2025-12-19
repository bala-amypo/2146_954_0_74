package com.example.demo.controller;

import com.example.demo.entity.ShipmentEntity;
import com.example.demo.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping("/{vehicleId}")
    public ResponseEntity<ShipmentEntity> createShipment(@PathVariable Long vehicleId, @RequestBody ShipmentEntity shipment) {
        ShipmentEntity savedShipment = shipmentService.createShipment(vehicleId, shipment);
        return ResponseEntity.ok(savedShipment);
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<ShipmentEntity> getShipment(@PathVariable Long shipmentId) {
        ShipmentEntity shipment = shipmentService.getShipment(shipmentId);
        return ResponseEntity.ok(shipment);
    }
}
