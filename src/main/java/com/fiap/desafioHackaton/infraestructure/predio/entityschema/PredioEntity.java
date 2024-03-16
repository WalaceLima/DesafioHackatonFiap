package com.fiap.desafioHackaton.infraestructure.predio.entityschema;


import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.hotel.entityschema.HotelEntity;
import com.fiap.desafioHackaton.infraestructure.quarto.entitySchema.QuartoEntity;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "predio")
public class PredioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "predio_id")
    private List<QuartoEntity> quartoEntities;

    public PredioEntity() {
    }

    public PredioEntity(Predio predio) {
        this.id = predio.getId();
        this.nome = predio.getNome();
        this.hotel = new HotelEntity(predio.getHotel());
    }

    public PredioEntity(Long id, String nome, HotelEntity hotel) {
        this.id = id;
        this.nome = nome;
        this.hotel = hotel;
    }

    public Predio toSimpleEntity() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity()
        );
        return predio;
    }

    public Predio toEntity() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity()
        );
        return predio;
    }

    public Predio toEntityWithQuartos() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.hotel.toEntity(),
                this.quartoEntities.stream().map(QuartoEntity::toSimpleEntity).collect(Collectors.toList())
        );
        return predio;
    }

    public Predio toEntityWithoutHotel() {
        Predio predio = new Predio(
                this.id,
                this.nome,
                this.quartoEntities.stream().map(QuartoEntity::toEntityToPredio).collect(Collectors.toList())
        );
        return predio;
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

    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }

    public List<QuartoEntity> getQuartoEntities() {
        return quartoEntities;
    }

    public void setQuartoEntities(List<QuartoEntity> quartoEntities) {
        this.quartoEntities = quartoEntities;
    }
}
