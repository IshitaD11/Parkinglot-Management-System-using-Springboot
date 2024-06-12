package org.example.parkinglot.exceptions;

public class GetParkingLotRequestValidationException extends Exception {
    public GetParkingLotRequestValidationException() {
    }

    public GetParkingLotRequestValidationException(String message) {
        super(message);
    }
}
