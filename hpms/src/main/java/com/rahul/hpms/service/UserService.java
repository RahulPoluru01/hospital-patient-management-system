package com.rahul.hpms.service;

import com.rahul.hpms.model.Doctor;
import com.rahul.hpms.model.Patient;
import com.rahul.hpms.model.User;
import com.rahul.hpms.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepo userRepo;

    UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public List<User> getAllUsers() {
      return  userRepo.findAll();
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }


}
