package com.fiap.desafioHackaton.domain.endereco.entity;

public class Endereco {

    private Long id;
    private String logradouro;
    private String cep;
    private String cidade;
    private String estado;


    public Endereco() {
    }

    ;

    public Endereco(Long id, String logradouro, String cep, String cidade, String estado) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco(String estado, String logradouro, String cep, String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
