package org.example.parkinglot.models;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.GateStatus;
import org.example.parkinglot.models.enums.GateType;

@Entity
@Getter
@Setter
public class Gate extends BaseModel {

    GateType gateType;
    GateStatus gateStatus;
    Operator operator;



}
