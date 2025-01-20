package br.com.projects.medvoll.domain.mapper;

import br.com.projects.medvoll.application.dto.Address.AddressRequest;
import br.com.projects.medvoll.application.dto.doctor.DoctorRequest;
import br.com.projects.medvoll.application.dto.doctor.DoctorResponse;
import br.com.projects.medvoll.domain.entities.Address;
import br.com.projects.medvoll.domain.entities.Doctor;
import br.com.projects.medvoll.infra.persistence.address.AddressEntity;
import br.com.projects.medvoll.infra.persistence.doctor.DoctorEntity;

public class DoctorMapper {
    public Doctor toDomain(DoctorEntity doctor) {

        Doctor dto = new Doctor(
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialty(),
                doctor.getCrm(),
                doctor.getEmail(),
                doctor.getPassword(),
                new Address(
                        doctor.getAddress().getStreet(),
                        doctor.getAddress().getNumber(),
                        doctor.getAddress().getComplement(),
                        doctor.getAddress().getCountry(),
                        doctor.getAddress().getCity(),
                        doctor.getAddress().getState()
                )
        );

        dto.setId(doctor.getId());

        return dto;
    }

    public Doctor toDomain(DoctorRequest doctor) {
        return new Doctor(
                doctor.firstName(),
                doctor.lastName(),
                doctor.specialty(),
                doctor.crm(),
                doctor.email(),
                doctor.password(),
                new Address(
                        doctor.address().street(),
                        doctor.address().number(),
                        doctor.address().complement(),
                        doctor.address().country(),
                        doctor.address().city(),
                        doctor.address().state()
                )
        );
    }

    public DoctorEntity toEntity(Doctor doctor) {
        return new DoctorEntity(
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialty(),
                doctor.getCrm(),
                doctor.getEmail(),
                doctor.getPassword(),
                doctor.getStatus(),
                new AddressEntity(
                        doctor.getAddress().getStreet(),
                        doctor.getAddress().getNumber(),
                        doctor.getAddress().getComplement(),
                        doctor.getAddress().getCountry(),
                        doctor.getAddress().getCity(),
                        doctor.getAddress().getState()
                )
        );
    }
    
    public DoctorResponse toResponse(Doctor doctor) {
        return new DoctorResponse(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getSpecialty(),
                doctor.getCrm(),
                doctor.getEmail(),
                new AddressRequest(
                        doctor.getAddress().getStreet(),
                        doctor.getAddress().getNumber(),
                        doctor.getAddress().getComplement(),
                        doctor.getAddress().getCountry(),
                        doctor.getAddress().getCity(),
                        doctor.getAddress().getState()
                )
        );
    }
}
