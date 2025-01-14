package br.com.projects.medvoll.infra.mapper;

import br.com.projects.medvoll.domain.entities.Attendant;

public class AttendantMapper {
    private Attendant attendant;

    public Attendant create(String name, String cpf, String email, String password) {
        return new Attendant(
                name,
                cpf,
                email,
                password
        );
    }

}
