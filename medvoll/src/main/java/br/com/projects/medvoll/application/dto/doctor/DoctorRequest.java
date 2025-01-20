package br.com.projects.medvoll.application.dto.doctor;

import br.com.projects.medvoll.application.dto.Address.AddressRequest;

public record DoctorRequest(
        String firstName,
        String lastName,
        String specialty,
        String crm,
        AddressRequest address,
        String email,
        String password
) {
}
