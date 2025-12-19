package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.service.RouteOptimizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optimize/result")
public class RouteOptimizationResultController {

    private final RouteOptimizationService routeOptimizationService;

    public RouteOptimizationResultController(RouteOptimizationService routeOptimizationService) {
        this.routeOptimizationService = routeOptimizationService;
    }

    // Get a previously generated optimization result
    @GetMapping("/{resultId}")
    public ResponseEntity<RouteOptimizationResultEntity> getResult(@PathVariable Long resultId) {
        RouteOptimizationResultEntity result = routeOptimizationService.getResult(resultId);
        return ResponseEntity.ok(result);
    }
}
