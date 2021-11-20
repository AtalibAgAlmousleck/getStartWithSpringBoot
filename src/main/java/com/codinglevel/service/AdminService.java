package com.codinglevel.service;

import com.codinglevel.entities.Admin;
import com.codinglevel.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> getAdmin() {
        return adminRepository.findAll();
    }

    public void addNewAdmin(Admin admin) {
        Optional<Admin> adminOptional = adminRepository
                .findAdminByEmail(admin.getEmail());
        if (adminOptional.isPresent()) {
            throw new IllegalStateException("Admin already exist");
        } else {
            adminRepository.save(admin);
        }
    }

    public void deleteAdmin(Long id) {
        boolean deleteAdminIfExist = adminRepository.existsById(id);
        if(!deleteAdminIfExist) {
            throw new IllegalStateException("Admin with id " + id + " does not exist");
        }else {
            adminRepository.deleteById(id);
        }
    }
}
