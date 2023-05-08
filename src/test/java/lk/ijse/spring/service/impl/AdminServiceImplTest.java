package lk.ijse.spring.service.impl;

import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.repo.AdminRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Autowired
    AdminRepo adminRepo;

    @Test
    void login() {
        Admin admin = adminRepo.loginSystem("admin", "1234");
        System.out.println(admin);
    }
}