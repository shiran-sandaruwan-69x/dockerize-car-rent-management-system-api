package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.BookingDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Booking;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.BookingRepo;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBooking(BookingDTO dto) {
        Booking booking = modelMapper.map(dto, Booking.class);
        booking.setBookingId(getLastID());

//        Booking booking1 = new Booking(
//                booking.getBookingId(),
//                booking.getDate(),
//                booking.getPickDate(),
//                booking.getStatus(),
//                booking.getNote(),
//                booking.getReturnDate(),
//                booking.getCustomer(),
//                booking.getCar(),
//                booking.getDriver()
//        );
        //System.out.println(booking);
        Booking save = bookingRepo.save(booking);
        System.out.println(save);
    }

    @Override
    public void updateBooking(BookingDTO dto) {
        if(bookingRepo.existsById(dto.getBookingID())){
            bookingRepo.save(modelMapper.map(dto, Booking.class));
        }else{
            throw new RuntimeException("No such Booking for update..!");
        }
    }

    @Override
    public void deleteBooking(String id) {
        if(bookingRepo.existsById(id)){
            bookingRepo.deleteById(id);
        }else{
            throw new RuntimeException("No such Booking for update..!");
        }
    }

    @Override
    public BookingDTO searchBooking(String id) {
        Optional<Booking> booking = bookingRepo.findById(id);
        if(booking.isPresent()){
            return modelMapper.map(booking, BookingDTO.class);
        }else{
            throw new RuntimeException("No Booking for id: " + id);
        }
    }

    @Override
    public List<BookingDTO> getAllBooking() {
        List<Booking> bookings = bookingRepo.findAll();
        List<BookingDTO> bookingDtos = new ArrayList<>();

        for (Booking b : bookings) {
            Customer customer = b.getCustomer();
            Car car = b.getCar();
            Driver driver = b.getDriver();

            CustomerDTO customer1 = modelMapper.map(customer, CustomerDTO.class);
            CarDTO car1 = modelMapper.map(car, CarDTO.class);
            DriverDTO driver1 = modelMapper.map(driver, DriverDTO.class);

            BookingDTO dto = modelMapper.map(b, BookingDTO.class);
            dto.setCustomerDto(customer1);
            dto.setCarDto(car1);
            dto.setDriverDto(driver1);

            bookingDtos.add(dto);

        }
        return bookingDtos;
    }



    @Override
    public String getLastID() {
        String lastID = bookingRepo.getLastID();
        if (lastID != null) {
            String[] split = lastID.split("B");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "B00" + id;
            else if (id < 100) return "B0" + id;
            else return "B" + id;
        }else{
            return "B001";
        }
    }

    @Override
    public BookingDTO searchBookingId(String cusid) {
       return bookingRepo.cusBook(cusid);

    }


}
