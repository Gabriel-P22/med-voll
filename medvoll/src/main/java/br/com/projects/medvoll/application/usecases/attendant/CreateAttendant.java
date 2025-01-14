package br.com.projects.medvoll.application.usecases.attendant;

import br.com.projects.medvoll.application.gateway.attendant.AttendantRepository;
import br.com.projects.medvoll.domain.entities.Attendant;

public class CreateAttendant {

    private final AttendantRepository repository;

    public CreateAttendant(AttendantRepository repository) {
        this.repository = repository;
    }

    public Attendant create(Attendant attendant) {
        return repository.create(attendant);
    }

}
