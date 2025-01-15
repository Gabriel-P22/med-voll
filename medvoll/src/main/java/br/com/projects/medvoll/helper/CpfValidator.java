package br.com.projects.medvoll.helper;

public class CpfValidator {
    public static void validator(String cpf) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("Invalid CPF");
        }
    }
}
