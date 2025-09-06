package com.rahul.hpms.service;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.model.Prescription;
import com.rahul.hpms.repo.AppointmentRepo;
import com.rahul.hpms.repo.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepo prescriptionRepo;

    @Autowired
    AppointmentRepo appointmentRepo;

    public Prescription addPrescription(int appointmentId, Prescription pres) {
        Optional<Appointment> optionalAppointment=appointmentRepo.findById(appointmentId);
        if(optionalAppointment.isPresent()){
            pres.setAppointment(optionalAppointment.get());
        }else{
            throw new RuntimeException("no appointment found with this ID:"+appointmentId);
        }
        return prescriptionRepo.save(pres);
    }

    public Prescription getPrescription(int appointmentId) {
        return prescriptionRepo.getPrescriptionByAppointment_id(appointmentId);
    }
}
