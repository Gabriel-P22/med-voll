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

}
