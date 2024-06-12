package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Bill extends BaseModel{

    private Date exitTime;
    private Integer amount;
    private Operator operator;
    private Token token;
    private List<Payment> payments;
    private Gate exitGate;

}
