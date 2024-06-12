package org.example.parkinglot.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private ResponseStatus responseStatus;
    private String message;

    public Response(ResponseStatus responseStatus, String message) {
        this.responseStatus = responseStatus;
        this.message = message;
    }

}
