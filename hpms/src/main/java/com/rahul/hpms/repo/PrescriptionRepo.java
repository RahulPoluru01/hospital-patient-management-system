package com.rahul.hpms.repo;

import com.rahul.hpms.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<Prescription,Integer> {
    Prescription getPrescriptionByAppointment_id(int pres);
}
