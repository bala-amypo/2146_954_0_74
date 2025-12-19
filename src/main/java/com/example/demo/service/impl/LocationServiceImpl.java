package com.example.demo.service.impl;

import com.example.demo.entity.LocationEntity;
import com.example.demo.repository.LocationRepository;
import com.example.demo.service.LocationService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationEntity saveLocation(LocationEntity location) {
        return locationRepository.save(location);
    }

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public LocationEntity getLocationById(Long id) {
        Optional<LocationEntity> location = locationRepository.findById(id);
        return location.orElse(null);
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
