package lk.ijse.spring.repo;


import lk.ijse.spring.entity.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.ResultSet;
import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "SELECT customer_id FROM customer ORDER BY customer_id DESC LIMIT 1", nativeQuery = true)
    String getLastID();

    @Query(value = "SELECT * FROM customer WHERE customer.user_name=?1 AND customer.password=?2",nativeQuery = true)
    Customer login(String userName, String password);

    @Query(value = "UPDATE customer SET verified='1' WHERE customerID=:id",nativeQuery = true)
    void verify(@Param("id") String id);

    Customer findByUserNameAndPassword(String userName, String password);

   // String findByCustomerIDOrderByCustomerIDDesc

   // String findFirstByCustomerIDOrderByCustomerIDDesc();


}
