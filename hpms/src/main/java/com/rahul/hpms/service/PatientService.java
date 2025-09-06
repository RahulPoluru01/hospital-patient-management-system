package com.rahul.hpms.service;

import com.rahul.hpms.model.Patient;
import com.rahul.hpms.model.User;
import com.rahul.hpms.repo.PatientRepo;
import com.rahul.hpms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepo patientRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PatientService(PatientRepo patientRepo){
        this.patientRepo=patientRepo;
    }


    public Patient addPatient(Patient patient){
      return  patientRepo.save(patient);
    }

    public List<Patient> getPatients() {
        return patientRepo.findAll();
    }

    public Patient addPatientById(int userId,Patient patient) {
        Optional<User> user=userRepo.findById(userId);
        if(user.isPresent()){
            patient.setUser(user.get());
        }else{
            throw new RuntimeException("no user found with patient_id"+userId);
        }
        return patientRepo.save(patient);
    }
}
