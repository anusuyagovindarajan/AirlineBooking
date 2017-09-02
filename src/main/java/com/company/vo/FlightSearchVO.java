package com.company.vo;


import java.util.ArrayList;


public class FlightSearchVO {

 String source;
 String destination;
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

    public ArrayList<FlightVO> getAvailableFlight() {
        return availableFlight;
    }

    public void setAvailableFlight(ArrayList<FlightVO> availableFlight) {
        this.availableFlight = availableFlight;
    }
}
