package com.example.demo.service.impl;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationEntity createLocation(LocationEntity location) {
        if (location.getLatitude() == null || location.getLatitude() > 90 || location.getLatitude() < -90) {
            throw new IllegalArgumentException("Invalid latitude value");
        }
        return locationRepository.save(location);
    }

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }
}
