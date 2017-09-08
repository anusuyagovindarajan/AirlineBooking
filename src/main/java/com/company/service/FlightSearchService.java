package com.company.service;

import com.company.repository.FlightRepository;
import com.company.repository.PlaneRepository;
import com.company.repository.SeatRepository;
import com.company.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;


@Service
public class FlightSearchService {

    FlightRepository flightRepository;
    PlaneRepository planeRepository;
    SeatRepository seatRepository;

    @Autowired
    public FlightSearchService(FlightRepository flightRepository, PlaneRepository planeRepository, SeatRepository seatRepository) {

        final Map<TravelClassType, SeatVO> seatTypes1 = new HashMap<TravelClassType, SeatVO>();
        final Map<TravelClassType, SeatVO> seatTypes2 = new HashMap<TravelClassType, SeatVO>();

        seatRepository.save(new SeatVO("2P2B", TravelClassType.Business, 20, 20, 10000.0));
        seatRepository.save(new SeatVO("2P2F", TravelClassType.First, 30, 30, 10000.0));
        seatRepository.save(new SeatVO("2P2E", TravelClassType.Economy, 195, 95, 6000.0));
        seatRepository.save(new SeatVO("3P3B", TravelClassType.Business, 20, 20, 10000.0));
        seatRepository.save(new SeatVO("3P3F", TravelClassType.First, 40, 40, 10000.0));
        seatRepository.save(new SeatVO("3P3E", TravelClassType.Economy, 195, 160, 6000.0));

        this.seatRepository = seatRepository;

        seatTypes1.put(TravelClassType.Business, seatRepository.findOne("2P2B"));
        seatTypes1.put(TravelClassType.First, seatRepository.findOne("2P2F"));
        seatTypes1.put(TravelClassType.Economy, seatRepository.findOne("2P2E"));

        seatTypes2.put(TravelClassType.Business, seatRepository.findOne("3P3B"));
        seatTypes2.put(TravelClassType.First, seatRepository.findOne("3P3F"));
        seatTypes2.put(TravelClassType.Economy, seatRepository.findOne("3P3E"));

        final PlaneVO plane1 = new PlaneVO("P2J23", "2P2", seatTypes1);
        final PlaneVO plane2 = new PlaneVO("P3J71", "3P3", seatTypes2);
        final PlaneVO plane3 = new PlaneVO("P2J88", "2P2", seatTypes1);
        final PlaneVO plane4 = new PlaneVO("P3J93", "3P3", seatTypes2);

        final List<PlaneVO> planes = Arrays.asList(plane1, plane2, plane3, plane4);

        for (PlaneVO plane : planes) {
            planeRepository.save(plane);
        }

        this.planeRepository = planeRepository;

        final FlightVO flight1 = new FlightVO("AHJ123", planeRepository.findOne("P2J23"),
                Location.Chennai, Location.Bangalore, LocalDate.of(2017, Month.SEPTEMBER, 13));
        final FlightVO flight2 = new FlightVO("AHJ234", planeRepository.findOne("P3J71"),
                Location.Bangalore, Location.Hyderabad, LocalDate.of(2017, Month.SEPTEMBER, 13));
        final FlightVO flight3 = new FlightVO("AHJ345", planeRepository.findOne("P2J88"),
                Location.Hyderabad, Location.Mumbai, LocalDate.of(2017, Month.SEPTEMBER, 13));
        final FlightVO flight4 = new FlightVO("AHJ129", planeRepository.findOne("P3J93"),
                Location.Chennai, Location.Bangalore, LocalDate.of(2017, Month.SEPTEMBER, 13));

        final List<FlightVO> flights = Arrays.asList(flight1, flight2, flight3, flight4);

        for (FlightVO flight : flights) {
            flightRepository.save(flight);
        }

        this.flightRepository = flightRepository;

    }

    public List<FlightVO> getAllFlights() {
        return flightRepository.findAll();
    }


    public FlightSearchVO searchFlight(FlightSearchVO flightSearchVO) {

        if (flightSearchVO.getCapacity() <= 0) {
            flightSearchVO.setCapacity(1);
        }

            List<FlightVO> allFlights = getAllFlights();

            ArrayList<FlightVO> availableFlights = new ArrayList<FlightVO>();


            for (FlightVO flight : allFlights) {
                if (flight.getSource().equals(flightSearchVO.getSource()) &&
                    flight.getDestination().equals(flightSearchVO.getDestination()) &&
                    (flight.getPlaneVO().getSeatTypes().get(flightSearchVO.getSeatClass()).getCurrentCapacity() >= flightSearchVO.getCapacity()) &&
                    (flight.getStartDate().equals(flightSearchVO.getStartDate()) || (flightSearchVO.getStartDate() == null))) {

                    LocalDate departureDate;
                    if(flightSearchVO.getStartDate()!=null){
                        departureDate = flightSearchVO.getStartDate();
                    }
                    else{
                        departureDate = flight.getStartDate();
                    }


                    if(flightSearchVO.getSeatClass().equals(TravelClassType.First)) {
                        long days = Period.between(LocalDate.now(),departureDate).getDays();
                        if(days <= 10 && days >0)
                            availableFlights.add(flight);
                    }
                    else{
                        availableFlights.add(flight);
                    }

                }

            }

            flightSearchVO.setAvailableFlight(availableFlights);
            return flightSearchVO;
        }


}
