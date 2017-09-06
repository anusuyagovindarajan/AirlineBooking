package com.company.vo;

import com.company.utility.Future;
import com.company.utility.LocalDateFutureValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class FlightVO extends LocalDateFutureValidator {

    @Id
    String flightNumber;
    @ManyToOne
    PlaneVO planeVO;
    @Enumerated(EnumType.STRING)
    Location source;
    @Enumerated(EnumType.STRING)
    Location destination;
    @DateTimeFormat(pattern = "dd-MM-YYYY")
    @Future
    LocalDate startDate;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

}
