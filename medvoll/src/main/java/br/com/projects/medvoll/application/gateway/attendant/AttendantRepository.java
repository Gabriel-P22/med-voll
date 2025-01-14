package br.com.projects.medvoll.application.gateway.attendant;


import br.com.projects.medvoll.domain.entities.Attendant;

public interface AttendantRepository {
    public Attendant create(Attendant attendant);
}
