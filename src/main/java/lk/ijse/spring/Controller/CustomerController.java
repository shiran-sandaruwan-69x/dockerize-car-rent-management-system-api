package lk.ijse.spring.Controller;


import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.service.DriverService;

import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    AdminService adminService;

    @Autowired
    DriverService driverService;

    @Autowired
    CustomerService customerService;



  @GetMapping(path = "/{userName}/{password}")
    public ResponseEntity login(@PathVariable("userName") String val1, @PathVariable("password") String val2){


        AdminDTO adminDto = adminService.getAdminLogin(val1, val2);
        CustomerDTO customerDto =customerService.login(val1, val2);
        DriverDTO driverDto = driverService.login(val1, val2);
       System.out.println(adminDto);
       System.out.println(customerDto);
       System.out.println(driverDto);

        if (customerDto != null){
            StandardResponse response = new StandardResponse(200, "customer", customerDto);
            return new ResponseEntity(response, HttpStatus.OK);
        }else {

            if (driverDto != null){
                StandardResponse response = new StandardResponse(200, "driver", driverDto);
                return new ResponseEntity(response, HttpStatus.OK);
            }else {
                if (adminDto != null){
                    StandardResponse response = new StandardResponse(200, "admin", adminDto);
                    return new ResponseEntity(response, HttpStatus.OK);
                }else{
                    StandardResponse response = new StandardResponse(500, "empty...!", null);
                    return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
                }

            }


        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDTO dto) {
        customerService.saveCustomer(dto);
        StandardResponse response = new StandardResponse(200, "Success", dto);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity verifyCustomer(@PathVariable String id){
        customerService.verifyCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchCustomer(@PathVariable String id) {
        CustomerDTO customerDTO = customerService.searchCustomer(id);
        return new ResponseEntity(new StandardResponse(200, "Success", customerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomer();
        return new ResponseEntity(new StandardResponse(200, "Success", allCustomers), HttpStatus.OK);
    }

//    @PostMapping(params="/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public String uploadFiles(@RequestParam("files") MultipartFile files) throws IOException {
//        System.out.println("ddddddd");
////       File file=new File("D:\\angular",files.getOriginalFilename());
////       file.createNewFile();
////       FileOutputStream fo=new FileOutputStream(file);
////       fo.write(files.getBytes());
////       fo.close();
//       return "gggg";
//       // String name=files.getOriginalFilename();
//
//    }









}
