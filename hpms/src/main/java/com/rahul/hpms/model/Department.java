package com.rahul.hpms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import java.util.List;

@Entity
public class Department {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
   // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JsonManagedReference
    private List<Doctor> doctors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", Dept_name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
