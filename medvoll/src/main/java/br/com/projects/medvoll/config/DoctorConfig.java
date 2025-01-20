package br.com.projects.medvoll.config;

import br.com.projects.medvoll.application.gateway.attendant.AttendantManagerImpl;
import br.com.projects.medvoll.application.gateway.doctor.DoctorManagerImpl;
import br.com.projects.medvoll.domain.mapper.DoctorMapper;
import br.com.projects.medvoll.domain.service.DoctorService;
import br.com.projects.medvoll.infra.persistence.doctor.DoctorRepositoryJpa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DoctorConfig {
    @Bean
    DoctorManagerImpl doctorRepositoryImpl(
            DoctorRepositoryJpa repository,
            DoctorMapper mapper
    ) {
        return new DoctorManagerImpl(repository, mapper);
    }

    @Bean
    DoctorService doctorService(
            DoctorManagerImpl doctorManager,
            AttendantManagerImpl attendantManager
    ) {
        return new DoctorService(attendantManager, doctorManager);
    }

    @Bean
    DoctorMapper doctorMapper() { return new DoctorMapper(); }

}
