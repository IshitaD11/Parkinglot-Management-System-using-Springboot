package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.FloorStatus;
import org.example.parkinglot.models.enums.VehicleType;

import java.util.List;

@Entity
@Getter
@Setter
public class ParkingFloor extends BaseModel{

    List<ParkingSlot> parkingSlots;
    FloorStatus floorStatus;

    List<VehicleType> supportedVehicleTypes;
}
