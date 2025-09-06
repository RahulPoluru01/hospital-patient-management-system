package com.rahul.hpms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
   @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
   private Integer id;
   private int age;
   private String gender;
   @OneToOne(cascade=CascadeType.ALL)
   @JoinColumn(name="user_id",nullable = false)
  // @JsonIgnore
   private User user;

//   @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
//   private List<Appointment> appointment = new ArrayList<>();

//   public List<Appointment> getAppointment() {
//      return appointment;
//   }
//
//   public void setAppointment(List<Appointment> appointment) {
//      this.appointment = appointment;
//   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getGender() {
      return gender;
   }

   public void setGender(String gender) {
      this.gender = gender;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }

   @Override
   public String toString() {
      return "Patient{" +
              "id=" + id +
              ", age=" + age +
              ", gender='" + gender + '\'' +
              ", user=" + user +
             // ", appointment=" + appointment +
              '}';
   }
}
