package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String id);
    void deleteCustomer(String id);
    List<CustomerDTO> getAllCustomer();
    String getLastLoginID();
    CustomerDTO login(String userName, String password);
    void verifyCustomer(String id);
}
