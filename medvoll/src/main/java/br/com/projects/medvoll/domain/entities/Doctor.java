package br.com.projects.medvoll.domain.entities;

import br.com.projects.medvoll.domain.enums.DoctorStatus;

public class Doctor {
    Long id;
    String specialty;
    String crm;
    DoctorStatus status;
    Address address;

    public Doctor() {}

    public Doctor(String specialty, String crm, DoctorStatus status, Address address) {
        this.specialty = specialty;
        this.crm = crm;
        this.status = status;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public DoctorStatus getStatus() {
        return status;
    }

    public void setStatus(DoctorStatus status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
