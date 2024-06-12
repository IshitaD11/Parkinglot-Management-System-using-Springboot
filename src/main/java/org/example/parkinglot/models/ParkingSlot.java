package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.ParkingSlotStatus;
import org.example.parkinglot.models.enums.VehicleType;

@Entity
@Getter
@Setter
public class ParkingSlot extends BaseModel{
    VehicleType supportedVehicleType;
    ParkingSlotStatus parkingSlotStatus;
}
