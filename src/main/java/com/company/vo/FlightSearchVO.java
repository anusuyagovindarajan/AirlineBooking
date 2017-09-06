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

}
