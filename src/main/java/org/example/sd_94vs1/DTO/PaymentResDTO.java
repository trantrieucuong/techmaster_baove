package org.example.sd_94vs1.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PaymentResDTO implements Serializable {
    private  String status;
    private String message;
    private String URL;
}