package br.com.projects.medvoll.domain.builder;

import br.com.projects.medvoll.domain.entities.Attendant;

public class AttendantBuilder {
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
