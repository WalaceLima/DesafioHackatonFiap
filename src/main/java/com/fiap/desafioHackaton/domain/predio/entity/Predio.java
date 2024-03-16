package com.fiap.desafioHackaton.domain.predio.entity;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;

import java.util.ArrayList;
import java.util.List;

public class Predio {

    private Hotel hotel;
    private Long id;
    private String nome;
    private List<Quarto> quartos = new ArrayList<>();


    public Predio() {

    }

    public Predio(Long id, String nome) {
        this.id = id;
        this.nome = nome;
        this.quartos = new ArrayList<>();
    }

    public Predio(String nome, List<Quarto> quartos) {
        this.nome = nome;
        this.quartos = new ArrayList<>();
    }

    public Predio(Long id, String nome, Hotel hotel) {
        this.id = id;
        this.hotel = hotel;
        this.nome = nome;
    }

    public Predio(String nome, Hotel hotel, List<Quarto> quartos) {
        this.id = id;
        this.hotel = hotel;
        this.nome = nome;
        this.quartos = quartos;
    }

    public Predio(Long id, String nome, Hotel hotel, List<Quarto> quartos) {
        this.id = id;
        this.hotel = hotel;
        this.nome = nome;
        this.quartos = quartos;
    }
    public Predio(Long id, String nome, List<Quarto> quartos) {
        this.id = id;
        this.nome = nome;
        this.quartos = quartos;
    }

    public Predio(String nome, Hotel hotel) {
        this.nome = nome;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public List<Quarto> getQuartos() {
        if (quartos == null) {
            quartos = new ArrayList<>();
        }
        return quartos;
    }
}
