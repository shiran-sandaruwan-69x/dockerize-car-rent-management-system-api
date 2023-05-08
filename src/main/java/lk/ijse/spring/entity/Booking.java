package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    private String bookingId;
    private String date;
    private String pickDate;
    private String status;
    private String note;
    private String returnDate;


    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "carId", referencedColumnName = "carId")
    private Car  car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId", referencedColumnName = "driverId")
    private Driver driver;





}
