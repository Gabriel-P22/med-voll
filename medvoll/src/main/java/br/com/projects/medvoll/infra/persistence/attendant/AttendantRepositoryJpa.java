package br.com.projects.medvoll.infra.persistence.attendant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendantRepositoryJpa extends JpaRepository<AttendantEntity, Long> {
    AttendantEntity findByCpf(String cpf);
    AttendantEntity findByEmail(String email);
}
