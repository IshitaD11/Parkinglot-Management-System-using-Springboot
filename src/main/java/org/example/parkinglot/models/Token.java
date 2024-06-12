package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Token extends BaseModel{
    private String tokenNumber;
    private Gate generatedAtGate;
    private Operator generatedBy;
    private Vehicle vehicle;
    private ParkingSlot assignedSlot;
}
