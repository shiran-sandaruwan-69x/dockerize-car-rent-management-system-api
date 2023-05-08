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
@Table(name = "Customer")
public class Customer {
    @Id
    private String customerId;
    private String name;
    private String contact;
    private String email;
    private String address;
    private String drivingLicenceNo;
    private String nicNo;
    @Column(nullable = false,columnDefinition = "TINYINT(1)")
    private int verified;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();



}
