package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResultEntity;
import java.util.List;

public interface RouteOptimizationResultService {  // ✅ Fixed class name
    RouteOptimizationResultEntity saveResult(RouteOptimizationResultEntity entity);
    List<RouteOptimizationResultEntity> getAllResults();
}
