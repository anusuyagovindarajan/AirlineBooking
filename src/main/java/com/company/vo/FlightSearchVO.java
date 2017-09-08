package com.company.vo;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class FlightSearchVO {

 Location source;
 Location destination;
 int capacity;
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 LocalDate startDate;
 TravelClassType seatClass;
 ArrayList<FlightVO> availableFlight;

    public Location getSource() {
        return source;
    }

    public void setSource(Location source) {
        this.source = source;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<FlightVO> getAvailableFlight() {
        return availableFlight;
    }

    public void setAvailableFlight(ArrayList<FlightVO> availableFlight) {
        this.availableFlight = availableFlight;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public TravelClassType getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(TravelClassType seatClass) {
        this.seatClass = seatClass;
    }

    public double surgePrice(FlightVO flight) {
        if(this.startDate == null)
          startDate = flight.getStartDate();
        TravelClassType seatClass = this.seatClass;
        int capacity = this.capacity;
        int initialCapacity = flight.getPlaneVO().getSeatTypes().get(seatClass).getInitialCapacity();
        int currentCapacity = flight.getPlaneVO().getSeatTypes().get(seatClass).getCurrentCapacity();
        double price = flight.getPlaneVO().getSeatTypes().get(seatClass).getPrice();

        int capacityDiff = (initialCapacity - currentCapacity);

        if (seatClass.equals(TravelClassType.Economy)) {
            if (capacityDiff >= 0.1 * initialCapacity && capacityDiff <= 0.4 * initialCapacity) {
                price = price;
            }
            else if (capacityDiff > 0.4 * initialCapacity && capacityDiff <= 0.9 * initialCapacity) {
                price = price + 0.3 * price;
            }
            else if (capacityDiff > 0.9 * initialCapacity && capacityDiff <= initialCapacity) {
                price =  price + 0.6 * price;
            }
        }

        String dayOfJourney = startDate.getDayOfWeek().name();

        if (seatClass.equals(TravelClassType.Business)) {

            if (dayOfJourney.equalsIgnoreCase("Monday") || dayOfJourney.equalsIgnoreCase("Friday") || dayOfJourney.equalsIgnoreCase("Sunday")) {

                price = price + 0.4 * price;

            }

        }

        return price * capacity;

    }

}
