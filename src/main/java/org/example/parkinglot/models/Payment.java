package org.example.parkinglot.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.parkinglot.models.enums.PaymentMode;
import org.example.parkinglot.models.enums.PaymentStatus;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private int amount;
    private PaymentMode paymentMode;
    private String paymentRefNo;
    private PaymentStatus paymentStatus;

}
