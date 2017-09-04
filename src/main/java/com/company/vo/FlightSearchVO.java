package com.company.vo;


import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class FlightSearchVO {

 String source;
 String destination;
 int capacity;
 @DateTimeFormat(pattern = "yyyy-MM-dd")
 LocalDate startDate;

 ArrayList<FlightVO> availableFlight;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
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
}
