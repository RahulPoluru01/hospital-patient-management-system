package com.rahul.hpms.repo;

import com.rahul.hpms.model.Appointment;
import com.rahul.hpms.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {



}
