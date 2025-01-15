package br.com.projects.medvoll.domain.mapper;

import br.com.projects.medvoll.application.exchange.attendant.AttendantRequest;
import br.com.projects.medvoll.domain.entities.Attendant;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantEntity;

public class AttendantMapper {
    public AttendantEntity toEntity(Attendant attendant) {
        return new AttendantEntity(
                attendant.getCpf(),
                attendant.getName(),
                attendant.getPassword(),
                attendant.getEmail()
                );
    }

    public Attendant toDomain(AttendantEntity attendant) {
        final Attendant domainEntity = new Attendant(
                attendant.getName(),
                attendant.getCpf(),
                attendant.getEmail(),
                attendant.getPassword()
        );

        domainEntity.setId(attendant.getId());

        return domainEntity;
    }

    public Attendant toDomain(AttendantRequest attendant) {
        return new Attendant(
                attendant.name(),
                attendant.cpf(),
                attendant.email(),
                attendant.password()
        );
    }

}
