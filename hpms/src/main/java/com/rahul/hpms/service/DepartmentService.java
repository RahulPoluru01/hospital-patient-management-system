package com.rahul.hpms.service;

import com.rahul.hpms.model.Department;
import com.rahul.hpms.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
   private DepartmentRepo departmentRepo;

    public Department addDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public List<Department> getDepartment() {
        return departmentRepo.findAll();
    }
}
