package br.com.projects.medvoll.application.gateway.doctor;

import br.com.projects.medvoll.domain.entities.Doctor;
import br.com.projects.medvoll.domain.mapper.DoctorMapper;
import br.com.projects.medvoll.exceptions.InvalidEmail;
import br.com.projects.medvoll.infra.persistence.doctor.DoctorRepositoryJpa;

public class DoctorManagerImpl implements DoctorManager {

    private final DoctorRepositoryJpa repository;
    private final DoctorMapper mapper;

    public DoctorManagerImpl(DoctorRepositoryJpa repository, DoctorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Doctor create(Doctor doctor) {

        if (repository.findByEmail(doctor.getEmail()) != null) {
            throw new InvalidEmail("Use another email");
        }

        return mapper.toDomain(
                repository.save(
                    mapper.toEntity(doctor)
                )
        );
    }
}
