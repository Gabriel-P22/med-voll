package br.com.projects.medvoll.config;

import br.com.projects.medvoll.application.gateway.attendant.AttendantManager;
import br.com.projects.medvoll.application.gateway.attendant.AttendantManagerImpl;
import br.com.projects.medvoll.domain.mapper.AttendantMapper;
import br.com.projects.medvoll.infra.persistence.attendant.AttendantRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttendantConfig {
    @Bean
    AttendantManagerImpl attendantRepositoryImpl(
            AttendantRepositoryJpa repository,
            AttendantMapper mapper
    ) {
        return new AttendantManagerImpl(repository, mapper);
    }

    @Bean
    AttendantMapper mapper() { return new AttendantMapper(); }

}
