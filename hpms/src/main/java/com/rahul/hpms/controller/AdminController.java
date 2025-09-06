package com.rahul.hpms.controller;

import com.rahul.hpms.model.Admin;
import com.rahul.hpms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getAdminDetails")
    public ResponseEntity<List<Admin>> getAdminDetails(){
        return ResponseEntity.ok(adminService.getAdminDetails());
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin){
        return ResponseEntity.ok(adminService.addAdminDetails(admin));
    }

}
