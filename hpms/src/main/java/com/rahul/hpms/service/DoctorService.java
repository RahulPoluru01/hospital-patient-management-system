package com.rahul.hpms.service;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.model.Department;
import com.rahul.hpms.model.Doctor;
import com.rahul.hpms.model.User;
import com.rahul.hpms.repo.DepartmentRepo;
import com.rahul.hpms.repo.DoctorRepo;
import com.rahul.hpms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepo doctorRepo;

    @Autowired
    UserRepo userRepo;
    @Autowired
    DepartmentRepo departmentRepo;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor addDoctorById(Doctor doctor,int doctorId, int dept_id) {
        Optional<User> user=userRepo.findById(doctorId);
        Optional<Department> department=departmentRepo.findById(dept_id);
        if(user.isPresent() && department.isPresent()){
            doctor.setUser(user.get());
            doctor.setDepartment(department.get());
        }else{
            throw new RuntimeException("no user found with doctorId and deptId"+doctorId+" "+dept_id);
        }
        return doctorRepo.save(doctor);
    }



}
