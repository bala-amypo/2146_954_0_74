package com.example.demo.service;

import com.example.demo.entity.LocationEntity;
import java.util.List;

public interface LocationService {
    LocationEntity saveLocation(LocationEntity location);
    List<LocationEntity> getAllLocations();
    LocationEntity getLocationById(Long id);
    void deleteLocation(Long id);
}
