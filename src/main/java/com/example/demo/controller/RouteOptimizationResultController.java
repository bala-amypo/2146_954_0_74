package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routes")
public class RouteOptimizationController {

    private final RouteOptimizationService routeService;

    public RouteOptimizationController(RouteOptimizationService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/optimize/{shipmentId}")
    public ResponseEntity<RouteOptimizationResultEntity> optimizeRoute(@PathVariable Long shipmentId) {
        RouteOptimizationResultEntity result = routeService.optimizeRoute(shipmentId);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{resultId}")
    public ResponseEntity<RouteOptimizationResultEntity> getResult(@PathVariable Long resultId) {
        RouteOptimizationResultEntity result = routeService.getResult(resultId);
        return ResponseEntity.ok(result);
    }
}
