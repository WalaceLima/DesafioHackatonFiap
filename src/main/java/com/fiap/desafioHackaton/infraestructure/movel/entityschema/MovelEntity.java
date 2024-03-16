package com.fiap.desafioHackaton.infraestructure.movel.entityschema;

import com.fiap.desafioHackaton.domain.movel.entity.Movel;
import jakarta.persistence.*;

@Entity
@Table(name = "movel")
public class MovelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    public MovelEntity() {
    }

    public MovelEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public MovelEntity(Movel movel) {
        this.id = movel.getId();
        this.nome = movel.getNome();
    }

    public Movel toEntity() {
        return new Movel(this.id, this.nome);
    }

    public Movel toEntityWithTipoQuarto() {
        return new Movel(
                this.id,
                this.nome

        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
