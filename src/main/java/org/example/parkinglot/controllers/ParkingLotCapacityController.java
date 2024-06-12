package org.example.parkinglot.controllers;

import org.example.parkinglot.dtos.GetParkingLotCapacityRequestDto;
import org.example.parkinglot.dtos.GetParkingLotCapacityResponseDto;
import org.example.parkinglot.dtos.Response;
import org.example.parkinglot.dtos.ResponseStatus;
import org.example.parkinglot.models.ParkingFloor;
import org.example.parkinglot.models.enums.VehicleType;
import org.example.parkinglot.services.strategy.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ParkingLotCapacityController {

    @Autowired
    private ParkingLotService parkingLotService;

    public ParkingLotCapacityController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public GetParkingLotCapacityResponseDto getParkingLotCapacity(
            GetParkingLotCapacityRequestDto getParkingLotCapacityRequestDto) {


        GetParkingLotCapacityResponseDto responseDto = new GetParkingLotCapacityResponseDto();
        validateRequest(getParkingLotCapacityRequestDto);

        try {
            System.out.println(STR."ParkingLotController: parkingLotId \{getParkingLotCapacityRequestDto.getParkingLotId()} floors: \{getParkingLotCapacityRequestDto.getParkingFloorIds()} vehicleTypes: \{getParkingLotCapacityRequestDto.getVehicleTypes()}");
            List<VehicleType> vehicleTypeList = new ArrayList<>();

            for (String vehicleType : getParkingLotCapacityRequestDto.getVehicleTypes()) {
                vehicleTypeList.add(VehicleType.valueOf(vehicleType));
            }

            Map<ParkingFloor, Map<String, Integer>> map =
                    parkingLotService.getParkingLotCapacity(getParkingLotCapacityRequestDto.getParkingLotId(),
                            getParkingLotCapacityRequestDto.getParkingFloorIds(),
                            vehicleTypeList);

            for(ParkingFloor pkf:map.keySet()){
                System.out.println(STR."parking floor: \{pkf.getId()} vehicleTypes \{map.get(pkf).keySet()} Capacity \{map.get(pkf).values()}");
            }

            responseDto.setCapacityMap(map);
            responseDto.setResponse(new Response(ResponseStatus.SUCCESS,""));

        }catch (Exception e){
            responseDto.setResponse(new Response(ResponseStatus.FAILURE,e.getMessage()));
        }



        System.out.println(STR."ParkingLotController: status \{responseDto.getResponse().getResponseStatus().toString()} message: \{responseDto.getResponse().getMessage()}");

        return responseDto;
    }

    private void validateRequest(GetParkingLotCapacityRequestDto request) {
        if (request.getParkingFloorIds() == null) {
            request.setParkingFloorIds(List.of());
        }
        if (request.getVehicleTypes() == null) {
            request.setVehicleTypes(List.of());
        }
    }
}
