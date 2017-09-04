package com.company.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
    @DateTimeFormat(pattern = "dd-MM-YYYY HH:mm")
    LocalDateTime startDate;

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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
