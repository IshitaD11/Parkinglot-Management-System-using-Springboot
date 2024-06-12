package org.example.parkinglot.services.strategy;

import org.example.parkinglot.exceptions.InvalidParkingLotException;
import org.example.parkinglot.models.ParkingFloor;
import org.example.parkinglot.models.ParkingLot;
import org.example.parkinglot.models.ParkingSlot;
import org.example.parkinglot.models.enums.ParkingSlotStatus;
import org.example.parkinglot.models.enums.VehicleType;
import org.example.parkinglot.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;


    public Map<ParkingFloor, Map<String, Integer>> getParkingLotCapacity(
            long parkingLotId, List<Long> parkingFloors, List<VehicleType> vehicleTypes)
            throws InvalidParkingLotException, InvalidParkingLotException {

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(parkingLotId);

        if(optionalParkingLot.isEmpty())
            throw new InvalidParkingLotException("Not a Valid Parking Lot Id");


        ParkingLot parkingLot = optionalParkingLot.get();
        Set<Long> allowedParkingFloors = getAllowedParkingFloors(parkingFloors, parkingLot);
        Set<VehicleType> allowedVehicleTypes = getAllowedVehicleTypes(vehicleTypes);

        return calculateParkingLotCapacity(parkingLot, allowedParkingFloors, allowedVehicleTypes);

    }

    private Set<Long> getAllowedParkingFloors(List<Long> parkingFloors, ParkingLot parkingLot) {
        Set<Long> allowedParkingFloors = new HashSet<>();
        if (parkingFloors.isEmpty()) {
            for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
                allowedParkingFloors.add(parkingFloor.getId());
            }
        } else {
            allowedParkingFloors.addAll(parkingFloors);
        }
        return allowedParkingFloors;
    }

    private Set<VehicleType> getAllowedVehicleTypes(List<VehicleType> vehicleTypes) {
        if (vehicleTypes.isEmpty()) {
            return EnumSet.allOf(VehicleType.class);
        } else {
            return new HashSet<>(vehicleTypes);
        }
    }

    private Map<ParkingFloor, Map<String, Integer>>
    calculateParkingLotCapacity(ParkingLot parkingLot,
                                Set<Long> allowedParkingFloors,
                                Set<VehicleType> allowedVehicleTypes) {

        Map<ParkingFloor, Map<String, Integer>> parkingFloorMap = new HashMap<>();

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            if (!allowedParkingFloors.contains(parkingFloor.getId())) {
                continue;
            }

            Map<String, Integer> vehicleTypeMap = new HashMap<>();
            for (ParkingSlot parkingSlot : parkingFloor.getParkingSlots()) {
                if (allowedVehicleTypes.contains(parkingSlot.getSupportedVehicleType())
                        && parkingSlot.getParkingSlotStatus().equals(ParkingSlotStatus.EMPTY)) {
                    String vehicleType = parkingSlot.getSupportedVehicleType().toString();
                    vehicleTypeMap.put(vehicleType, vehicleTypeMap.getOrDefault(vehicleType, 0) + 1);
                }
            }

            parkingFloorMap.put(parkingFloor, vehicleTypeMap);
        }

        return parkingFloorMap;
    }
}
