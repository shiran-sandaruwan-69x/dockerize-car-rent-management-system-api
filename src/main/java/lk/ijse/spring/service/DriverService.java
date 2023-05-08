package lk.ijse.spring.service;


import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);
    void updateDriver(DriverDTO dto);
    void deleteDriver(String id);
    DriverDTO searchDriver(String id);
    List<DriverDTO> getAllDrivers();
    String getLastID();
    DriverDTO login(String userName, String password);
    void setAvailable(DriverDTO dto);
    DriverDTO getRandomDriver();
}
