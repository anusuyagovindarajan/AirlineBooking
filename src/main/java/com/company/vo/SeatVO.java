package com.company.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SeatVO {

    @Id
    String planeSeatTypeModel;
    String type;
    int capacity;
    double price;

    public String getPlaneSeatTypeModel() {
        return planeSeatTypeModel;
    }

    public void setPlaneSeatTypeModel(String planeSeatTypeModel) {
        this.planeSeatTypeModel = planeSeatTypeModel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
