package lk.ijse.spring.Controller;


import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity savePayment(@RequestBody PaymentDTO dto){
        paymentService.savePayment(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity updatePayment(@RequestBody PaymentDTO dto){
        paymentService.updatePayment(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deletePayment(@RequestParam String id){
        paymentService.deletePayment(id);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchPayment(@PathVariable String id){
        PaymentDTO paymentDto = paymentService.searchPayment(id);
        StandardResponse response = new StandardResponse(200, "Success", paymentDto);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllPayments(){
        List<PaymentDTO> payments = paymentService.getAllPayments();
        StandardResponse response = new StandardResponse(200, "Success", payments);
        return new ResponseEntity(response, HttpStatus.OK);
    }



}
