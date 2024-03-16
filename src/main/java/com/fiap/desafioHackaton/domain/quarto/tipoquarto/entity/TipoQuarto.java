package com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity;

import com.fiap.desafioHackaton.domain.movel.entity.Movel;

import java.util.List;

public class TipoQuarto {
    private Long id;
    private String nomeTipo;
    private Integer capacidadeTotal;
    private String quantidadeCamas;
    private String banheiro;

    private List<Movel> moveis;

    public TipoQuarto() {
    }

    public TipoQuarto(Long id, String nomeTipo, Integer capacidadeTotal, String quantidadeCamas, String banheiro) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
        this.banheiro = banheiro;
    }

    public TipoQuarto(Long id, String nomeTipo, Integer capacidadeTotal, String quantidadeCamas, String banheiro, List<Movel> moveis) {
        this.id = id;
        this.nomeTipo = nomeTipo;
        this.capacidadeTotal = capacidadeTotal;
        this.quantidadeCamas = quantidadeCamas;
        this.banheiro = banheiro;
        this.moveis = moveis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public Integer getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public void setCapacidadeTotal(Integer capacidadeTotal) {
        this.capacidadeTotal = capacidadeTotal;
    }

    public String getQuantidadeCamas() {
        return quantidadeCamas;
    }

    public void setQuantidadeCamas(String quantidadeCamas) {
        this.quantidadeCamas = quantidadeCamas;
    }

    public List<Movel> getMoveis() {
        return moveis;
    }

    public void setMoveis(List<Movel> moveis) {
        this.moveis = moveis;
    }
}
