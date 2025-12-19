package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicle;

    @ManyToOne
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private LocationEntity pickupLocation;

    @ManyToOne
    @JoinColumn(name = "drop_location_id", nullable = false)
    private LocationEntity dropLocation;

    private Double weightKg;

    private LocalDate scheduledDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public VehicleEntity getVehicle() { return vehicle; }
    public void setVehicle(VehicleEntity vehicle) { this.vehicle = vehicle; }

    public LocationEntity getPickupLocation() { return pickupLocation; }
    public void setPickupLocation(LocationEntity pickupLocation) { this.pickupLocation = pickupLocation; }

    public LocationEntity getDropLocation() { return dropLocation; }
    public void setDropLocation(LocationEntity dropLocation) { this.dropLocation = dropLocation; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }

    public LocalDate getScheduledDate() { return scheduledDate; }
    public void setScheduledDate(LocalDate scheduledDate) { this.scheduledDate = scheduledDate; }
}
