package br.com.projects.medvoll.application.usecases.attendant;

import br.com.projects.medvoll.application.gateway.attendant.AttendantRepository;
import br.com.projects.medvoll.domain.entities.Attendant;

public class AttendantManager {

    private final AttendantRepository repository;

    public AttendantManager(AttendantRepository repository) {
        this.repository = repository;
    }

    public Attendant create(Attendant attendant) {
        return repository.create(attendant);
    }

    public Attendant findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public void delete(String cpf) {
        repository.delete(cpf);
    }

}
