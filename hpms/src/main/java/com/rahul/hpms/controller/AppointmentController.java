package com.rahul.hpms.controller;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.service.AppointmentService;
import com.rahul.hpms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    AppointmentService appointmentService;


    @Autowired
    AppointmentController(AppointmentService service){
        appointmentService=service;
    }

    @PostMapping("/bookAppointment")
    public ResponseEntity<Appointment> bookA(@RequestBody Appointment appointment){
        return ResponseEntity.ok(appointmentService.bookAppointment(appointment));
    }

    @PostMapping("/{patientId}/{doctorId}/bookAppointment")
    public ResponseEntity<Appointment> bookById(@PathVariable int patientId,@PathVariable int doctorId, @RequestBody Appointment appointment){
        return ResponseEntity.ok(appointmentService.bookAppointmentById(patientId,doctorId,appointment));
    }

    @PostMapping("/{doctorId}/bookAppointment")
    public ResponseEntity<Appointment> bookAppointment(@PathVariable int doctorId,@RequestBody Appointment appointment){
        return ResponseEntity.ok(appointmentService.bookAppointmentForDoctorId(doctorId,appointment));
    }

    @GetMapping("/{doctorId}/getDoctorAppointments")
    public ResponseEntity<List<Appointment>> getDoctorAppointments(@PathVariable int doctorId){
        return ResponseEntity.ok(appointmentService.getAllAppointmentsById(doctorId));
    }

    @GetMapping("/{patientId}/getPatientAppointments")
    public ResponseEntity<List<Appointment>> getPatientsAppointments(@PathVariable int patientId){
        return ResponseEntity.ok(appointmentService.getAllAppointmentsByPatientId(patientId));
    }

    @PatchMapping("/updateStatus/{appointment_id}")
    public ResponseEntity<Appointment> updateStatus(@RequestBody String status , @PathVariable int appointment_id){
        return ResponseEntity.ok(appointmentService.updateStatus(status,appointment_id));
    }

}
