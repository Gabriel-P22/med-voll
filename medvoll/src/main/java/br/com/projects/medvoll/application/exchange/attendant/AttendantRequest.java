package br.com.projects.medvoll.application.exchange.attendant;

public record AttendantRequest(
    String name,
    String email,
    String cpf,
    String password
) {
}
