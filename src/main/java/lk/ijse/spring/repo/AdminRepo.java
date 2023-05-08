package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Admin;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import javax.persistence.QueryHint;
import java.sql.ResultSet;
import java.util.List;
import java.util.stream.Stream;

public interface AdminRepo extends JpaRepository<Admin, String> {

    @Query(value = "SELECT adminid FROM admin ORDER BY adminid DESC LIMIT 1", nativeQuery = true)
    String getLastID();

    @Modifying
    @Query(value = "SELECT * FROM admin",nativeQuery = true)
    List<Admin> login();


    @Query(value="SELECT * FROM admin WHERE admin.user_name=:userName AND admin.password=:password",nativeQuery = true)
    Admin loginSystem(String userName,String password);

    Admin findByUserNameAndPassword(String userName, String password);

}
