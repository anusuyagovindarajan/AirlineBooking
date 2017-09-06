package com.company.vo;

import com.sun.javafx.collections.MappingChange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlaneVO {

    @Id
    String planeNumber;
    String planeModel;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Map<TravelClassType,SeatVO> seatTypes;

    public String getPlaneNumber() {
        return planeNumber;
    }

    public void setPlaneNumber(String planeNumber) {
        this.planeNumber = planeNumber;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
    }

    public Map<TravelClassType, SeatVO> getSeatTypes() {
        return seatTypes;
    }

    public void setSeatTypes(Map<TravelClassType, SeatVO> seatTypes) {
        this.seatTypes = seatTypes;
    }
}
