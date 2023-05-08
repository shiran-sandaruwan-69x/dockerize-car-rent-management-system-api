package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.DriverService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {


    @Autowired
    AdminService adminService;

    @Autowired
    DriverService driverService;

    @Autowired
    CustomerService customerService;

    @Test
    void login() {
        //AdminDTO admin = adminService.getAdminLogin("admin", "1234");
        //CustomerDTO tashi = customerService.login("tashi", "1234");
       // System.out.println(tashi);
    }
}