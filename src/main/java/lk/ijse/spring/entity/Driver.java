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
@Table(name = "Driver")
public class Driver {
    @Id
    private String driverId;
    private String name;
    private String contactNo;
    private String nic;
    @Column(nullable = false,columnDefinition = "TINYINT(1)")
    private int available;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Booking> bookings = new ArrayList<>();

}
