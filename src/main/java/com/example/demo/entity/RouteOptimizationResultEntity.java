package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "route_optimization_results")
public class RouteOptimizationResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String routeDetails;

    private double totalDistance;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRouteDetails() { return routeDetails; }
    public void setRouteDetails(String routeDetails) { this.routeDetails = routeDetails; }

    public double getTotalDistance() { return totalDistance; }
    public void setTotalDistance(double totalDistance) { this.totalDistance = totalDistance; }
}
