package br.com.projects.medvoll.application.gateway.attendant;

import br.com.projects.medvoll.domain.entities.Attendant;
import br.com.projects.medvoll.exceptions.InvalidEmail;
import br.com.projects.medvoll.exceptions.NotFoundException;
import br.com.projects.medvoll.domain.mapper.AttendantMapper;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantEntity;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantRepositoryJpa;

public class AttendantManagerImpl implements AttendantManager {

    private final AttendantRepositoryJpa repository;

    private final AttendantMapper mapper;

    public AttendantManagerImpl(AttendantRepositoryJpa repository, AttendantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Attendant create(Attendant attendant) {

        if (repository.findByEmail(attendant.getEmail()) != null) {
            throw new InvalidEmail("Use another email");
        }

        return mapper.toDomain(
                repository.save(
                        mapper.toEntity(attendant)
                )
        );
    }

    @Override
    public Attendant findByCpf(String cpf) {
        return mapper.toDomain(
                findAttendantByCpf(cpf)
        );
    }

    @Override
    public Attendant update(String cpf, Attendant attendant) {

        if (cpf == null) {
            throw new IllegalArgumentException("CPF is required");
        }

        var attendantEntity = findAttendantByCpf(cpf);

        if (attendant.getName() != null) {
            attendantEntity.setName(attendant.getName());
        }

        if (attendant.getEmail() != null) {
            if (repository.findByEmail(attendant.getEmail()) != null) {
                throw new InvalidEmail("Select another email");
            }

            attendantEntity.setEmail(attendant.getEmail());
        }

        repository.save(attendantEntity);

        return mapper.toDomain(attendantEntity);
    }

    @Override
    public Attendant findById(Long id) {
        return mapper.toDomain(
                findEntityById(id)
        );
    }

    @Override
    public void delete(String cpf) {
        repository.delete(findAttendantByCpf(cpf));
    }

    private AttendantEntity findAttendantByCpf(String cpf) {
        var attendant = repository.findByCpf(cpf);

        if (attendant == null) {
            throw new NotFoundException("Attendant not found");
        }

        return attendant;
    }

    private AttendantEntity findEntityById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Attendant not found"));
    }
}
