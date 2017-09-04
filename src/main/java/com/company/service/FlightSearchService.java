package com.company.service;

import com.company.repository.PlaneRepository;
import com.company.vo.PlaneVO;
import javafx.util.converter.LocalDateTimeStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.repository.FlightRepository;
import com.company.vo.FlightSearchVO;
import com.company.vo.FlightVO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Service
public class FlightSearchService {

    FlightRepository flightRepository;
    PlaneRepository planeRepository;

    @Autowired public FlightSearchService(FlightRepository flightRepository, PlaneRepository planeRepository ) {


        final PlaneVO plane1 = new PlaneVO("P2J23", "2P2", 90);
        final PlaneVO plane2 = new PlaneVO("P3J71", "3P3", 240);
        final PlaneVO plane3 = new PlaneVO("P2J88", "2P2", 78);
        final PlaneVO plane4 = new PlaneVO("P3J93", "3P3", 270);

        final List<PlaneVO> planes = Arrays.asList(plane1, plane2, plane3, plane4);

        for (PlaneVO plane : planes) {
            planeRepository.save(plane);
        }

        this.planeRepository = planeRepository;

        final FlightVO flight1 = new FlightVO("AHJ123",planeRepository.findOne("P2J23"),
                "Chennai","Bangalore", LocalDateTime.of(2017, Month.SEPTEMBER,30,0,0));
        final FlightVO flight2 = new FlightVO("AHJ234",planeRepository.findOne("P3J71"),
                "Bangalore","Hyderabad", LocalDateTime.of(2017, Month.SEPTEMBER,30,0,0));
        final FlightVO flight3 = new FlightVO("AHJ345",planeRepository.findOne("P2J88"),
                "Hyderabad","Mumbai",LocalDateTime.of(2017, Month.SEPTEMBER,30,0,0));
        final FlightVO flight4 = new FlightVO("AHJ129",planeRepository.findOne("P3J93"),
                "Chennai","Bangalore",LocalDateTime.of(2017, Month.SEPTEMBER,30,0,0));

        final List<FlightVO> flights = Arrays.asList(flight1, flight2, flight3, flight4);

        for (FlightVO flight : flights) {
            flightRepository.save(flight);
        }

        this.flightRepository= flightRepository;

    }

    public List<FlightVO> getAllFlights() {
        return flightRepository.findAll();
    }



    public FlightSearchVO searchFlight(String Source, String Destination, int Capacity, LocalDateTime StartDate){

        if(Capacity == 0){
            Capacity=1;
        }

        List<FlightVO> allFlights = getAllFlights();

        ArrayList<FlightVO> availableFlights = new ArrayList<FlightVO>();
        FlightSearchVO flightSearchVO = new FlightSearchVO();

        flightSearchVO.setSource(Source);
        flightSearchVO.setDestination(Destination);
        flightSearchVO.setCapacity(Capacity);
        flightSearchVO.setStartDate(StartDate);

        for(FlightVO flight : allFlights){
            if(flight.getSource().equalsIgnoreCase(Source) &&
                    flight.getDestination().equalsIgnoreCase(Destination) &&
                    (flight.getPlaneVO().getCapacity()>=Capacity) &&
                    (flight.getStartDate().equals(StartDate) || (StartDate == null))){

                availableFlights.add(flight);

            }

        }

        flightSearchVO.setAvailableFlight(availableFlights);
        return flightSearchVO;
    }

}
