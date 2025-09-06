package com.rahul.hpms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String  specialization;
    private String  availability;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",nullable = false)
   // @JsonIgnore
    private User user;
    @ManyToOne
    @JoinColumn(name = "dept_id",nullable = false)
    @JsonBackReference
    private Department department;
//    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
//    private List<Appointment> appointment= new ArrayList<>();

//    public List<Appointment> getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(List<Appointment> appointment) {
//        this.appointment = appointment;
//    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", specialization='" + specialization + '\'' +
                ", availability='" + availability + '\'' +
                ", user=" + user +
                ", department=" + department +
                '}';
    }
}
