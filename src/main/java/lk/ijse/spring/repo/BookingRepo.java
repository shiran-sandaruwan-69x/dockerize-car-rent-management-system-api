package lk.ijse.spring.repo;


import lk.ijse.spring.dto.BookingDTO;
import lk.ijse.spring.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepo extends JpaRepository<Booking,String> {
    @Query(value = "SELECT booking_id FROM booking ORDER BY booking_id DESC LIMIT 1", nativeQuery = true)
    String getLastID();


    @Query(value = "SELECT * FROM booking WHERE booking_id=:bookingID",nativeQuery = true)
    BookingDTO cusBook(@Param("bookingID") String bookingID);

}
