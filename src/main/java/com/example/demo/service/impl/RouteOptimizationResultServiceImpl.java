package com.example.demo.service.impl;

import com.example.demo.entity.RouteOptimizationResultEntity;
import com.example.demo.repository.RouteOptimizationResultRepository;
import com.example.demo.service.RouteOptimizationResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteOptimizationResultServiceImpl implements RouteOptimizationResultService {

    @Autowired
    private RouteOptimizationResultRepository repository;

    @Override
    public RouteOptimizationResultEntity saveResult(RouteOptimizationResultEntity result) {
        return repository.save(result);
    }

    @Override
    public List<RouteOptimizationResultEntity> getAllResults() {
        return repository.findAll();
    }
}
