package com.company.service;

import com.company.vo.FlightSearchVO;
import com.company.vo.FlightVO;
import com.company.vo.TravelClassType;

import java.time.LocalDate;
import java.time.Period;

public class PricingService {

    public double surgePrice(FlightSearchVO flightSearchVO, FlightVO flight) {

        if(flightSearchVO.getStartDate() == null)
            flightSearchVO.setStartDate(flight.getStartDate());

        TravelClassType seatClass = flightSearchVO.getSeatClass();
        int capacity = flightSearchVO.getCapacity();
        int initialCapacity = flight.getPlaneVO().getSeatTypes().get(seatClass).getInitialCapacity();
        int currentCapacity = flight.getPlaneVO().getSeatTypes().get(seatClass).getCurrentCapacity();
        double price = flight.getPlaneVO().getSeatTypes().get(seatClass).getPrice();

        int capacityDiff = (initialCapacity - currentCapacity);

        if (seatClass.equals(TravelClassType.Economy)) {

            price = economySurgeCalculate(capacityDiff, initialCapacity, price);

        }

        String dayOfJourney = flightSearchVO.getStartDate().getDayOfWeek().name();

        if (seatClass.equals(TravelClassType.Business)) {

           price = businessSurgeCalculate(dayOfJourney, price);

        }

        if(seatClass.equals(TravelClassType.First)){

            price = firstSurgeCalculate(price, flightSearchVO);

        }

        return price * capacity;

    }

    private double economySurgeCalculate(int capacityDiff,int initialCapacity, double price){
        if (capacityDiff >= 0.1 * initialCapacity && capacityDiff <= 0.4 * initialCapacity) {
            price = price;
        }
        else if (capacityDiff > 0.4 * initialCapacity && capacityDiff <= 0.9 * initialCapacity) {
            price = price + 0.3 * price;
        }
        else if (capacityDiff > 0.9 * initialCapacity && capacityDiff <= initialCapacity) {
            price = price + 0.6 * price;
        }

        return price;
    }

    private double firstSurgeCalculate(double price, FlightSearchVO flightSearchVO){

        int daysLeft = Period.between(LocalDate.now(),flightSearchVO.getStartDate()).getDays();

        switch (daysLeft){
            case 10:
                price = price;
                break;
            case 9:
                price = price + 0.1*price;
                break;
            case 8:
                price = price + 0.2*price;
                break;
            case 7:
                price = price + 0.3*price;
                break;
            case 6:
                price = price + 0.4*price;
                break;
            case 5:
                price = price + 0.5*price;
                break;
            case 4:
                price = price + 0.6*price;
                break;
            case 3:
                price = price + 0.7*price;
                break;
            case 2:
                price = price + 0.8*price;
                break;
            case 1:
                price = price + 0.9*price;
                break;
            case 0:
                price = price + 1*price;
                break;

        }
        return price;
    }

    private double businessSurgeCalculate(String dayOfJourney, double price ){

        if (dayOfJourney.equalsIgnoreCase("Monday") || dayOfJourney.equalsIgnoreCase("Friday") || dayOfJourney.equalsIgnoreCase("Sunday")) {

            price = price + 0.4 * price;

        }
        return price;
    }

}


