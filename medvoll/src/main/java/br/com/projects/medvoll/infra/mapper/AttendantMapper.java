package br.com.projects.medvoll.infra.mapper;

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
                attendant.getPassword(),
                attendant.getEmail()
        );

        domainEntity.setId(attendant.getId());

        return domainEntity;
    }

}
