package lk.ijse.spring.Controller;

import lk.ijse.spring.dto.BookingDTO;
import lk.ijse.spring.service.BookingService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity bookCar(@RequestBody BookingDTO dto){
       // System.out.println(dto.toString());
      bookingService.saveBooking(dto);
      StandardResponse response = new StandardResponse(200, "Success", null);
      return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateBooking(@RequestBody BookingDTO dto){
        bookingService.saveBooking(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteBooking(@RequestParam String id){
        bookingService.deleteBooking(id);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity getBooking(@PathVariable String id){
        String idd="B001";
        BookingDTO booking = bookingService.searchBookingId(idd);
        StandardResponse response = new StandardResponse(200, "Success", booking);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllBookings(){
        List<BookingDTO> allBooking = bookingService.getAllBooking();
        StandardResponse response = new StandardResponse(200, "Success", allBooking);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
