package com.company.service;

import com.company.repository.LocationRepository;
import com.company.vo.LocationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LocationProviderService {

    LocationRepository locationRepository;

    @Autowired public LocationProviderService(LocationRepository locationRepository) {

        final LocationVO city1 = new LocationVO("CHE","Chennai");
        final LocationVO city2 = new LocationVO("BMB","Mumbai");
        final LocationVO city3 = new LocationVO("HYD","Hyderabad");
        final LocationVO city4 = new LocationVO("BLR","Bangalore");
        final LocationVO city5 = new LocationVO("CBE","Coimbatore");
        final LocationVO city6 = new LocationVO("KTA","Kolkata");

        final List<LocationVO> locations = Arrays.asList(city1,city2,city3,city4,city5,city6);

        for(LocationVO location : locations) {
            locationRepository.save(location);
        }

        this.locationRepository = locationRepository;
    }


    public List<LocationVO> getLocations() {
        return locationRepository.findAll();
    }

}
