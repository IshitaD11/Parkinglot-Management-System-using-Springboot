package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.EmploymentStatus;

@Entity
@Getter
@Setter
public class Operator extends BaseModel{
    String operatorName;
    EmploymentStatus employmentStatus;
}
