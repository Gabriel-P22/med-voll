package br.com.projects.medvoll.application.dto.Address;

public record AddressResponse(
        String street,
        String number,
        String complement,
        String country,
        String city,
        String state
) {
}
