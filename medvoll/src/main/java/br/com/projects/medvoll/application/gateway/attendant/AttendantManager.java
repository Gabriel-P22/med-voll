package br.com.projects.medvoll.application.gateway.attendant;


import br.com.projects.medvoll.domain.entities.Attendant;

public interface AttendantManager {
    Attendant create(Attendant attendant);
    Attendant findByCpf(String cpf);
    Attendant update(String cpf, Attendant attendant);
    void delete(String cpf);
}
