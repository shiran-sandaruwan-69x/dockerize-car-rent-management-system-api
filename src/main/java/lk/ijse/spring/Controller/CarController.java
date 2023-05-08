package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCar(@RequestBody CarDTO dto) {
        carService.saveCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCar(@RequestBody CarDTO dto){
        carService.updateCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteCar(@RequestParam String id){
        carService.deleteCar(id);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCar(@PathVariable("id")String id){
        CarDTO carDto = carService.searchCar(id);
        StandardResponse response = new StandardResponse(200, "Success", carDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/type/{type}")
    public ResponseEntity searchCarbytype(@PathVariable("type")String id){
        List<CarDTO> allSerchCars = carService.searchCarbyType(id);
        StandardResponse response = new StandardResponse(200, "Success", allSerchCars);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCars(){
        List<CarDTO> allCars = carService.getAllCars();
        StandardResponse response = new StandardResponse(200, "Success", allCars);
        return new ResponseEntity(response, HttpStatus.OK);
    }

}
