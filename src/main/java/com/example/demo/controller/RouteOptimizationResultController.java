package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.service.RouteOptimizationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/route-optimization")
public class RouteOptimizationResultController {  // ✅ Fixed class name
    @Autowired
    private RouteOptimizationResultService routeOptimizationResultService;

    @PostMapping("/save")
    public RouteOptimizationResultEntity saveResult(@RequestBody RouteOptimizationResultEntity entity) {
        return routeOptimizationResultService.saveResult(entity);
    }

    @GetMapping("/all")
    public List<RouteOptimizationResultEntity> getAllResults() {
        return routeOptimizationResultService.getAllResults();
    }
}
