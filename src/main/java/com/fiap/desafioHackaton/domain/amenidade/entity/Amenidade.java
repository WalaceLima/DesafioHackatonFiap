package com.fiap.desafioHackaton.domain.amenidade.entity;

public class Amenidade {

    private Long id;
    private String nome;

    public Amenidade(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
