package com.rahul.hpms.service;

import com.rahul.hpms.model.Admin;
import com.rahul.hpms.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;


    public List<Admin> getAdminDetails() {
        return adminRepo.findAll();
    }

    public Admin addAdminDetails(Admin admin) {
        return adminRepo.save(admin);
    }
}
