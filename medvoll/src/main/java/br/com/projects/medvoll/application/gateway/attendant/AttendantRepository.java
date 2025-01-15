package br.com.projects.medvoll.application.gateway.attendant;


import br.com.projects.medvoll.domain.entities.Attendant;

public interface AttendantRepository {
    Attendant create(Attendant attendant);
    Attendant findByCpf(String cpf);
    void delete(String cpf);
}
