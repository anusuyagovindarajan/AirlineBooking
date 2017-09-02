package com.company.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlightVO {

    @Id
    String flightNumber;
    @ManyToOne
    PlaneVO planeVO;
    String source;
    String destination;

    public PlaneVO getPlaneVO() {
        return planeVO;
    }

    public void setPlaneVO(PlaneVO planeVO) {
        this.planeVO = planeVO;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

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
}
