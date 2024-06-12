package org.example.parkinglot.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.ParkingFloor;
import java.util.Map;

@Getter
@Setter
public class GetParkingLotCapacityResponseDto {

    private Response response;

    private Map<ParkingFloor, Map<String, Integer>> capacityMap;


}
