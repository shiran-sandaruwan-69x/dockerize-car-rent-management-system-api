package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private String paymentID;
    private String cusId;
    private String carId;
    private String date;
    private String returnDate;
    private double noOfKm;
    private double amount;
}
