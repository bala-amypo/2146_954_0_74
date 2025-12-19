package com.example.demo.service.impl;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.LocationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationServiceImpl {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public LocationEntity saveLocation(LocationEntity location) {
        return locationRepository.save(location);
    }

    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }
}
