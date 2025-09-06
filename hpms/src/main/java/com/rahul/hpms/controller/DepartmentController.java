package com.rahul.hpms.controller;

import com.rahul.hpms.model.Department;
import com.rahul.hpms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return ResponseEntity.ok(departmentService.addDepartment(department));
    }

    @GetMapping("/getAllDepartments")
    public ResponseEntity<List<Department>> getDepartments(){
        return ResponseEntity.ok(departmentService.getDepartment());
    }

}
