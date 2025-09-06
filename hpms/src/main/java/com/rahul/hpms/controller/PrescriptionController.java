package com.rahul.hpms.controller;

import com.rahul.hpms.model.Prescription;
import com.rahul.hpms.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/{appointment_id}/prescription")
    public ResponseEntity<Prescription> addPres(@PathVariable int appointment_id, @RequestBody Prescription pres){
        return ResponseEntity.ok(prescriptionService.addPrescription(appointment_id,pres));
    }

    @GetMapping("/pres/{appointment_id}")
    public ResponseEntity<Prescription> getPres(@PathVariable int appointment_id){
        return ResponseEntity.ok(prescriptionService.getPrescription(appointment_id));
    }

}
