package com.fiap.desafioHackaton.infraestructure.amenidade.entityschema;

import com.fiap.desafioHackaton.domain.amenidade.entity.Amenidade;
import jakarta.persistence.*;

@Entity
@Table(name = "amenidade")
public class AmenidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public AmenidadeEntity() {
    }

    public AmenidadeEntity(Amenidade amenidade) {
        this.id = amenidade.getId();
        this.nome = amenidade.getNome();
    }

    public Amenidade toEntity() {
        return new Amenidade(
                this.getId(),
                this.getNome()
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
