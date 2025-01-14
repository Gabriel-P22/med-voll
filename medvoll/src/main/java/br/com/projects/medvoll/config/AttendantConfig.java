package br.com.projects.medvoll.config;

import br.com.projects.medvoll.application.gateway.attendant.AttendantRepository;
import br.com.projects.medvoll.application.usecases.attendant.CreateAttendant;
import br.com.projects.medvoll.infra.gateway.AttendantRepositoryImpl;
import br.com.projects.medvoll.infra.mapper.AttendantMapper;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttendantConfig {

    @Bean
    CreateAttendant createAttendant(AttendantRepository repository) {
        return new CreateAttendant(repository);
    }

    @Bean
    AttendantRepositoryImpl attendantRepositoryImpl(
            AttendantRepositoryJpa repository,
            AttendantMapper mapper
    ) {
        return new AttendantRepositoryImpl(repository, mapper);
    }

    @Bean
    AttendantMapper mapper() { return new AttendantMapper(); }

}
