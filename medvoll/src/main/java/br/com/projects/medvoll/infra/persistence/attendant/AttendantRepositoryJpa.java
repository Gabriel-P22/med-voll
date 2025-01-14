package br.com.projects.medvoll.infra.persistence.attendant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface AttendantRepositoryJpa extends JpaRepository<AttendantEntity, Long> {




}
