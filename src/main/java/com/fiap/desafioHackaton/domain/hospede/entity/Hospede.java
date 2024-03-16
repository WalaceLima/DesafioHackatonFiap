package com.fiap.desafioHackaton.domain.hospede.entity;

import java.time.LocalDate;

public class Hospede {
    private Long id;
    private String paisOrigem;
    private String cpf;
    private String passaporte;
    private String nome;
    private LocalDate dataNascimento;
    private String enderecoPaisOrigem;
    private String telefone;
    private String email;

    public Hospede() {
    }

    ;


    public Hospede(String paisOrigem, String cpf, String passaporte, String nome
            , LocalDate dataNascimento, String enderecoPaisOrigem, String telefone, String email) {
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }


    public Hospede(Long id, String paisOrigem, String cpf, String passaporte, String nome
            , LocalDate dataNascimento, String enderecoPaisOrigem, String telefone, String email) {
        this.id = id;
        this.paisOrigem = paisOrigem;
        this.cpf = cpf;
        this.passaporte = passaporte;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.enderecoPaisOrigem = enderecoPaisOrigem;
        this.telefone = telefone;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaisOrigem() {
        return paisOrigem;
    }

    public void setPaisOrigem(String paisOrigem) {
        this.paisOrigem = paisOrigem;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEnderecoPaisOrigem() {
        return enderecoPaisOrigem;
    }

    public void setEnderecoPaisOrigem(String enderecoPaisOrigem) {
        this.enderecoPaisOrigem = enderecoPaisOrigem;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
