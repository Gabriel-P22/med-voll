package br.com.projects.medvoll.application.dto.attendant;

public record AttendantRequest(
    String name,
    String email,
    String cpf,
    String password
) {
}
