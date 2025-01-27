package br.com.projects.medvoll.application.dto.doctor;

import br.com.projects.medvoll.application.dto.Address.AddressRequest;

public record DoctorResponse(
        Long id,
        String firstName,
        String lastName,
        String specialty,
        String crm,
        String email,
        AddressRequest address
) {
}
