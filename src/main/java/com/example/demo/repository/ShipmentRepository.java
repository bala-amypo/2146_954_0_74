package com.example.demo.repository;

import com.example.demo.entity.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShipmentRepository extends JpaRepository<ShipmentEntity, Long> {
    List<ShipmentEntity> findByVehicleId(Long vehicleId);
}
