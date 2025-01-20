package br.com.projects.medvoll.infra.persistence.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepositoryJpa extends JpaRepository<DoctorEntity, Long> {
    DoctorEntity findByEmail(String email);
}
