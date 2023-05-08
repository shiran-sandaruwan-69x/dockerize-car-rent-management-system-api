package lk.ijse.spring.repo;


import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver, String> {
    @Query(value = "SELECT driver_id FROM driver ORDER BY driver_id DESC LIMIT 1", nativeQuery = true)
    String getLastID();

    @Query(value = "SELECT * FROM driver WHERE user_name=:userName AND password=:password",nativeQuery = true)
    Driver login(@Param("userName") String userName, @Param("password") String password);

    @Query(value = "SELECT * FROM driver WHERE available=?1 ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Driver getRandomDriver(boolean i);

    @Query(value = "UPDATE driver SET available=?1 WHERE driverID=?2",nativeQuery = true)
    void setAvailable(int i,String id);
}
