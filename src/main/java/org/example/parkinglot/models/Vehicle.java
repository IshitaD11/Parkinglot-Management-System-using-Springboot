package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.VehicleType;

@Entity
@Getter
@Setter
public class Vehicle extends BaseModel{
    String VehicleNumber;
    VehicleType vehicleType;
    String ownerName;
}
