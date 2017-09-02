package com.company.service;

import com.company.vo.PlaneVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.repository.FlightRepository;
import com.company.vo.FlightSearchVO;
import com.company.vo.FlightVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class FlightSearchService {

    FlightRepository flightRepository;



    @Autowired public FlightSearchService(FlightRepository flightRepository ) {

        final PlaneVO plane1 = new PlaneVO("P2J23","2P2",90);
        final FlightVO flight1 = new FlightVO("AHJ123",plane1,"Chennai","Bangalore");
        final PlaneVO plane2 = new PlaneVO("P3J71","3P3",240);
        final FlightVO flight2 = new FlightVO("AHJ234",plane2,"Bangalore","Hyderabad");
        final PlaneVO plane3 = new PlaneVO("P2J88","2P2",78);
        final FlightVO flight3 = new FlightVO("AHJ345",plane3,"Hyderabad","Mumbai");
        final PlaneVO plane4 = new PlaneVO("P3J93","3P3",270);
        final FlightVO flight4 = new FlightVO("AHJ129",plane4,"Chennai","Bangalore");

        final List<FlightVO> flights = Arrays.asList(flight1, flight2, flight3, flight4);

        for (FlightVO flight : flights) {
            flightRepository.save(flight);
        }

        this.flightRepository= flightRepository;

    }

    public List<FlightVO> getAllFlights() {
        return flightRepository.findAll();
    }



    public FlightSearchVO searchFlight(String Source, String Destination){

        List<FlightVO> allFlights = getAllFlights();

        ArrayList<FlightVO> availableFlights = new ArrayList<FlightVO>();
        FlightSearchVO flightSearchVO = new FlightSearchVO();

        flightSearchVO.setSource(Source);
        flightSearchVO.setDestination(Destination);

        for(FlightVO flight : allFlights){
            if(flight.getSource().equalsIgnoreCase(Source) && flight.getDestination().equalsIgnoreCase(Destination)){

                availableFlights.add(flight);

            }

        }
        flightSearchVO.setAvailableFlight(availableFlights);
        return flightSearchVO;
    }

}
