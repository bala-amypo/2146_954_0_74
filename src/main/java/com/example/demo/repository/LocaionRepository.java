package com.example.demo.service.impl;

import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl {
    private final LocationRepository locationRepository;
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }
}
