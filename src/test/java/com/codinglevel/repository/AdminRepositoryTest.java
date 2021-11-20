package com.codinglevel.repository;

import com.codinglevel.entities.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdminRepositoryTest {

    private final AdminRepository adminRepository;

    @Autowired
    AdminRepositoryTest(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Test
    public void saveAdmin() {
        Admin admin = Admin.builder()
                .name("Atalib")
                .email("atalib@gmail.com")
                .password("testing")
                .build();

        Admin admin1 = Admin.builder()
                .name("Mohamed")
                .email("momo@gmail.com")
                .password("testing")
                .build();

        Admin admin2 = Admin.builder()
                .name("Hamdi")
                .email("hamdi@gmail.com")
                .password("testing")
                .build();

        adminRepository.saveAll(List.of( admin,
                admin1,
                admin2));
    }
}