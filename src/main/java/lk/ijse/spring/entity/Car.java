package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Car")
public class Car {
    @Id
    private String carId;
    private String brands;
    private String type;
    private int numberOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double priceForExtraKM;
    private String registrationNumber;
    private String colour;
    private double dailyRate;
    private double monthlyRate;
    private double lossDamageWaiver;
    private double freeMillagePrice;
    private String freeMillageDuration;

    @OneToMany(mappedBy = "car",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();
}
