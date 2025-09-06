package com.rahul.hpms.controller;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.model.Patient;
import com.rahul.hpms.repo.PatientRepo;
import com.rahul.hpms.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

   private  PatientService patientService;

   @Autowired
    PatientController(PatientService patientService){
       this.patientService=patientService;
    }

   @PostMapping("/addPatient")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient){
       return ResponseEntity.ok(patientService.addPatient(patient));
   }

    @PostMapping("/{userId}/addPatient")
    public ResponseEntity<Patient> addPatientById(@PathVariable int userId, @RequestBody Patient patient){
        return ResponseEntity.ok(patientService.addPatientById(userId,patient));
    }

   @GetMapping("/allPatients")
    public ResponseEntity<List<Patient>> getPatients(){
       return ResponseEntity.ok(patientService.getPatients());
   }



}
