package com.example.demo.controller;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.service.RouteOptimizationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route-results")
public class RouteOptimizationResultController {

    @Autowired
    private RouteOptimizationResultService routeOptimizationResultService;

    @GetMapping
    public List<RouteOptimizationResultEntity> getAllResults() {
        return routeOptimizationResultService.getAllResults();
    }

    @PostMapping
    public RouteOptimizationResultEntity saveResult(@RequestBody RouteOptimizationResultEntity result) {
        return routeOptimizationResultService.saveResult(result);
    }
}
