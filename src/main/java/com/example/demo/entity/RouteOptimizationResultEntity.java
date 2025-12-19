package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResultEntity {  // ✅ Fixed class name
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeName;
    private Double distance;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteName() { return routeName; }
    public void setRouteName(String routeName) { this.routeName = routeName; }

    public Double getDistance() { return distance; }
    public void setDistance(Double distance) { this.distance = distance; }
}
