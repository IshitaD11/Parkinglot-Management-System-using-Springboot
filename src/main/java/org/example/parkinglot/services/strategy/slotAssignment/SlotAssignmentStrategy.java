package org.example.parkinglot.services.strategy.slotAssignment;

import org.example.parkinglot.models.ParkingLot;
import org.example.parkinglot.models.ParkingSlot;

public interface SlotAssignmentStrategy {

    ParkingSlot assignSlot(ParkingLot parkingLot);
}
