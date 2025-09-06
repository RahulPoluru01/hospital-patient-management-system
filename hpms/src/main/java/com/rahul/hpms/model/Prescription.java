package com.rahul.hpms.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String doctor_notes;
    private String medicine_list;
    private LocalDate next_visit;
    @OneToOne
    @JoinColumn(name = "appointment_id",nullable = false)
    private Appointment appointment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDoctor_notes() {
        return doctor_notes;
    }

    public void setDoctor_notes(String doctor_notes) {
        this.doctor_notes = doctor_notes;
    }

    public String getMedicine_list() {
        return medicine_list;
    }

    public void setMedicine_list(String medicine_list) {
        this.medicine_list = medicine_list;
    }

    public LocalDate getNext_visit() {
        return next_visit;
    }

    public void setNext_visit(LocalDate next_visit) {
        this.next_visit = next_visit;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    @Override
    public String toString() {
        return "Prescription{" +
                "id=" + id +
                ", doctor_notes='" + doctor_notes + '\'' +
                ", medicine_list='" + medicine_list + '\'' +
                ", next_visit=" + next_visit +
                ", appointment=" + appointment +
                '}';
    }
}
