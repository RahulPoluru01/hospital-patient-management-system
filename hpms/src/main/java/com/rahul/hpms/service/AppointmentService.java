package com.rahul.hpms.service;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.model.Doctor;
import com.rahul.hpms.model.Patient;
import com.rahul.hpms.repo.AppointmentRepo;
import com.rahul.hpms.repo.DoctorRepo;
import com.rahul.hpms.repo.PatientRepo;
import com.rahul.hpms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @Autowired
    private PatientRepo patientrepo;

    @Autowired
    private DoctorRepo doctorrepo;

    @Autowired
    private UserRepo userRepo;

    public Appointment bookAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public Appointment bookAppointmentById(int patientId,int doctorId, Appointment appointment) {
        Optional<Patient> patient=patientrepo.findById(patientId);
        Optional<Doctor> doctor=doctorrepo.findById(doctorId);
        if(patient.isPresent() && doctor.isPresent()){
            appointment.setPatient(patient.get());
            appointment.setDoctor(doctor.get());
        }else{
            throw new RuntimeException("no patient and doctor found with this id's"+patientId+" "+doctorId);
        }
        return appointmentRepo.save(appointment);
    }

    public Appointment bookAppointmentForDoctorId(int doctorId, Appointment appointment) {
        Optional<Doctor> doctor=doctorrepo.findById(doctorId);
        if(doctor.isPresent()){
            appointment.setDoctor(doctor.get());
        }else{
            throw new RuntimeException("no doctor found with this id:"+doctorId);
        }
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> getAllAppointmentsById(int doctor_id) {
        return appointmentRepo.getAllAppointmentsByDoctor_id(doctor_id);
    }

    public List<Appointment> getAllAppointmentsByPatientId(int patient_id) {
        return appointmentRepo.getAllAppointmentsByPatient_id(patient_id);
    }

    public Appointment updateStatus(String status, int appointmentId) {
        Optional<Appointment> appointment=appointmentRepo.findById(appointmentId);
        if (appointment.isPresent()){
            appointment.get().setStatus(status);
        }else{
            throw new RuntimeException("no appointment with this id:"+appointmentId);
        }
        return appointmentRepo.save(appointment.get());
    }
}
