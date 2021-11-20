package com.codinglevel.controller;

import com.codinglevel.entities.Admin;
import com.codinglevel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    public final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "/all")
    public List<Admin> getAdmin() {
       return adminService.getAdmin();
    }

    @PostMapping("/save")
    public void addNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
    }
}
