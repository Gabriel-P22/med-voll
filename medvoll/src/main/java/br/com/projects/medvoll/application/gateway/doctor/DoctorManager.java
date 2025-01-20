package br.com.projects.medvoll.application.gateway.doctor;


import br.com.projects.medvoll.domain.entities.Doctor;

public interface DoctorManager {
    Doctor create(Doctor doctor);
}
