package br.com.projects.medvoll.domain.entities;

import br.com.projects.medvoll.domain.helper.CpfValidator;

public class Attendant {

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;

    public Attendant(String name, String cpf, String email, String password) {
        CpfValidator.validator(cpf);
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        CpfValidator.validator(cpf);

        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Attendant{" +
                ", cpf='" + cpf + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
