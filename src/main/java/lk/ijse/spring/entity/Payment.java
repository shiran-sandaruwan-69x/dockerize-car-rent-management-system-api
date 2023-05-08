package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Payment")
public class Payment {
    @Id
    private String paymentId;
    private String cusId;
    private String carId;
    private String date;
    private String returnDate;
    private double noOfKm;
    private double amount;

}
