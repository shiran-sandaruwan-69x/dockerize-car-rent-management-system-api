package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);
    void updateCar(CarDTO dto);
    void deleteCar(String id);
    CarDTO searchCar(String id);
    List<CarDTO> getAllCars();
    String getLastID();
    List<CarDTO> searchCarbyType(String id);
}
