package com.fiap.desafioHackaton.infraestructure.hotel.entityschema;


import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.amenidade.entityschema.AmenidadeEntity;
import com.fiap.desafioHackaton.infraestructure.endereco.entityschema.EnderecoEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.item.entityschema.ItemEntity;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.entityschema.ServicoEntity;
import com.fiap.desafioHackaton.infraestructure.predio.entityschema.PredioEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "hotel")
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;
    private String nome;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private EnderecoEntity endereco;

    @OneToMany(mappedBy = "hotel")
    private List<PredioEntity> predios = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "hotel_amenidades",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "amenidade_id"))
    private Set<AmenidadeEntity> amenidades = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "hotel_itens",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<ItemEntity> itens = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "hotel_servicos",
            joinColumns = @JoinColumn(name = "hotel_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private Set<ServicoEntity> servicos = new HashSet<>();

    public HotelEntity() {
    }

    public HotelEntity(Hotel hotel) {
        this.id = hotel.getId();
        this.nome = hotel.getNome();
        this.endereco = new EnderecoEntity(hotel.getEndereco());
    }

    public Hotel toEntity() {

        return new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity()
        );


    }

    public Hotel toCompleteEntity() {
        return new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity(),
                this.predios.stream().map(PredioEntity::toEntity).collect(Collectors.toList()),
                this.amenidades.stream().map(AmenidadeEntity::toEntity).collect(Collectors.toList()),
                this.servicos.stream().map(ServicoEntity::toEntity).collect(Collectors.toList()),
                this.itens.stream().map(ItemEntity::toEntity).collect(Collectors.toList())
        );
    }


    public Hotel toEntityWithPredios() {

        return new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity(),
                this.predios.stream().map(PredioEntity::toSimpleEntity).collect(Collectors.toList())
        );
    }


    public Hotel toEntityWithServicos() {
        Hotel hotel = new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity()


        );


        this.servicos.stream().forEach(servicoEntity -> {
            Servico servico = servicoEntity.toEntity();
            hotel.addServico(servico);
        });

        return hotel;
    }

    public Hotel toEntityWithItens() {
        Hotel hotel = new Hotel(
                this.getId(),
                this.nome,
                this.endereco.toEntity()


        );


        this.itens.stream().forEach(itemEntity -> {
            Item item = itemEntity.toEntity();
            hotel.addItem(item);
        });

        return hotel;
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

    public EnderecoEntity getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    public List<PredioEntity> getPredios() {
        return predios;
    }

    public void setPredios(List<PredioEntity> predios) {
        this.predios = predios;
    }

    public Set<AmenidadeEntity> getAmenidades() {
        return amenidades;
    }

    public void setAmenidades(Set<AmenidadeEntity> amenidades) {
        this.amenidades = amenidades;
    }

    public Set<ItemEntity> getItens() {
        return itens;
    }

    public void setItens(Set<ItemEntity> itens) {
        this.itens = itens;
    }

    public Set<ServicoEntity> getServicos() {
        return servicos;
    }

    public void setServicos(Set<ServicoEntity> servicos) {
        this.servicos = servicos;
    }
}
