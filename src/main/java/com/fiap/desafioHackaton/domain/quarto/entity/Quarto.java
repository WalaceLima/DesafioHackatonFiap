package com.fiap.desafioHackaton.domain.quarto.entity;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;

import java.math.BigDecimal;
import java.util.Objects;

public class Quarto {

    private Long id;
    private Predio predio;
    private Long idHotel;
    private BigDecimal valorDiaria;
    private Status status;
    private TipoQuarto tipoQuarto;


    public Quarto() {
    }

    public Quarto(Predio predio, TipoQuarto tipoQuarto, Status status, BigDecimal valorDiaria) {
        this.predio = predio;
        this.tipoQuarto = tipoQuarto;
        this.status = status;
        this.valorDiaria = valorDiaria;
    }

    public Quarto(Long id, Predio predio, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.predio = predio;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Quarto(Long id, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Quarto(Long id, BigDecimal valorDiaria, Status status, TipoQuarto tipoQuarto) {
        this.id = id;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }

    public Quarto(Long idQuarto, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuartoEntity tipoQuarto) {
        this.id = idQuarto;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto.toEntity();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Predio getPredio() {
        return predio;
    }

    public void setPredio(Predio predio) {
        this.predio = predio;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(BigDecimal valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quarto quarto = (Quarto) o;

        return Objects.equals(id, quarto.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
