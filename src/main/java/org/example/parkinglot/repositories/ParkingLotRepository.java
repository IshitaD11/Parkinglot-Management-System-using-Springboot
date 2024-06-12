package org.example.parkinglot.repositories;

import org.example.parkinglot.models.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {


//    public Optional<ParkingLot> getParkingLotById(long id);


}
