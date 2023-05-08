package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO dto);
    void updateAdmin(AdminDTO dto);
    AdminDTO searchAdmin(String id);
    void deleteAdmin(String id);
    List<AdminDTO> getAllAdmin();
    String getLastLoginID();
    List<AdminDTO> login();

    AdminDTO getAdminLogin(String user_name,String password);

}
