package br.com.projects.medvoll.infra.gateway;

import br.com.projects.medvoll.application.gateway.attendant.AttendantRepository;
import br.com.projects.medvoll.domain.entities.Attendant;
import br.com.projects.medvoll.infra.mapper.AttendantMapper;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantEntity;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantRepositoryJpa;

public class AttendantRepositoryImpl implements AttendantRepository {

    private final AttendantRepositoryJpa repository;

    private final AttendantMapper mapper;

    public AttendantRepositoryImpl(AttendantRepositoryJpa repository, AttendantMapper mapper) {
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
    public void delete(String cpf) {
        repository.delete(findAttendantByCpf(cpf));
    }

    private AttendantEntity findAttendantByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
