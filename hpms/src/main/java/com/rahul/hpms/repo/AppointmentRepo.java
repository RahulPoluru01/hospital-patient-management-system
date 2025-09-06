package com.rahul.hpms.repo;

import com.rahul.hpms.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Integer> {
    List<Appointment> getAllAppointmentsByDoctor_id(int doctor_id);
    List<Appointment> getAllAppointmentsByPatient_id(int doctor_id);
}
