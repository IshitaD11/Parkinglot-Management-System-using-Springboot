package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.ParkingLotStatus;
import org.example.parkinglot.models.enums.VehicleType;
import org.example.parkinglot.services.strategy.feeCalculation.FeeCalculationStrategy;
import org.example.parkinglot.services.strategy.slotAssignment.SlotAssignmentStrategy;

import java.util.List;

@Entity
@Getter
@Setter
public class ParkingLot extends BaseModel{

    List<ParkingFloor> parkingFloors;
    ParkingLotStatus parkingLotStatus;
    List<Gate> gates;
    List<VehicleType> supportedVehicleTypes;

    int capacity;

    SlotAssignmentStrategy slotAssignmentStrategy;
    FeeCalculationStrategy feeCalculationStrategy;

}
