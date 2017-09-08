package com.company.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SeatVO {

    @Id
    String planeSeatTypeModel;
    @Enumerated(EnumType.STRING)
    TravelClassType type;
    int initialCapacity;
    int currentCapacity;
    double price;

    public String getPlaneSeatTypeModel() {
        return planeSeatTypeModel;
    }

    public void setPlaneSeatTypeModel(String planeSeatTypeModel) {
        this.planeSeatTypeModel = planeSeatTypeModel;
    }

    public TravelClassType getType() {
        return type;
    }

    public void setType(TravelClassType type) {
        this.type = type;
    }

    public int getInitialCapacity() { return initialCapacity; }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    public int getCurrentCapacity() { return currentCapacity; }

    public void setCurrentCapacity(int currentCapacity) { this.currentCapacity = currentCapacity; }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = price;
    }
}
