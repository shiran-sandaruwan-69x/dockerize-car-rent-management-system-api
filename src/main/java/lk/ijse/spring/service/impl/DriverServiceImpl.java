package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        Driver driver = mapper.map(dto, Driver.class);
        driver.setDriverId(getLastID());
        driver.setAvailable(1);
        driverRepo.save(driver);
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverID())){
            driverRepo.save(mapper.map(dto,Driver.class));
        }else {
            throw new RuntimeException("No such driver for update..!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (driverRepo.existsById(id)){
            driverRepo.deleteById(id);
        } else {
            throw new RuntimeException("No customer for delete id: " + id);
        }
    }

    @Override
    public DriverDTO searchDriver(String id) {
        Optional<Driver> driver = driverRepo.findById(id);
        if (driver.isPresent()){
            return mapper.map(driver, DriverDTO.class);
        }else{
            throw new RuntimeException("No driver for id: " + id);
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> drivers = driverRepo.findAll();
        return mapper.map(drivers, new TypeToken<List<DriverDTO>>(){}.getType());
    }

    @Override
    public String getLastID() {
        String lastID = driverRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("D");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "D00" + id;
            else if (id < 100) return "D0" + id;
            else return "D" + id;
        }else{
            return "D001";
        }
    }

    @Override
    public DriverDTO login(String userName, String password) {
        Driver driver = driverRepo.login(userName, password);
        if (driver == null){
            //throw new RuntimeException("Check Login details");
            return null;
        }

        return mapper.map(driver,DriverDTO.class);
    }

    @Override
    public void setAvailable(DriverDTO dto) {
        Optional<Driver> driver = driverRepo.findById(dto.getDriverID());
        if (driver.isPresent()){
            Driver driver1 = driver.get();
            driver1.setAvailable(0);
            driverRepo.save(driver1);
        }

    }

    @Override
    public DriverDTO getRandomDriver() {
        Driver randomDriver = driverRepo.getRandomDriver(true);
        return mapper.map(randomDriver,DriverDTO.class);
    }
}
