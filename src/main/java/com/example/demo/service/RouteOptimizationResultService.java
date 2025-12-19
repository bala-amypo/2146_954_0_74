package com.example.demo.service;

import com.example.demo.entity.RouteOptimizationResultEntity;

import java.util.List;

public interface RouteOptimizationResultService {
    RouteOptimizationResultEntity saveResult(RouteOptimizationResultEntity result);
    List<RouteOptimizationResultEntity> getAllResults();
}
