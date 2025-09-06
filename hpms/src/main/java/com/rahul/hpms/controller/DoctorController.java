package com.rahul.hpms.controller;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.model.Doctor;
import com.rahul.hpms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorservice;
    @PostMapping("/addDoctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
        return ResponseEntity.ok(doctorservice.addDoctor(doctor));
    }

    @PostMapping("addDoctor/{user_Id}/{dept_id}")
    public ResponseEntity<Doctor> addDoctor( @RequestBody Doctor doctor,@PathVariable int user_Id,@PathVariable int dept_id){
        return ResponseEntity.ok(doctorservice.addDoctorById(doctor,user_Id,dept_id));
    }

    @GetMapping("/getDoctors")
    public ResponseEntity<List<Doctor>> getDoctors(){
        return ResponseEntity.ok(doctorservice.getDoctors());
    }




}
