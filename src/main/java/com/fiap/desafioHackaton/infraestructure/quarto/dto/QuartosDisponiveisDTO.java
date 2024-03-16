package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.infraestructure.tipoquarto.entityschema.TipoQuartoEntity;

import java.math.BigDecimal;

public class QuartosDisponiveisDTO {

    private Long idQuarto;
    private Long idPredio;
    private Long idHotel;
    private BigDecimal valorDiaria;
    private Status status;
    private TipoQuartoEntity tipoQuarto;


    public QuartosDisponiveisDTO(){}

    public QuartosDisponiveisDTO(Long idQuarto, Long idPredio, Long idHotel, BigDecimal valorDiaria, Status status, TipoQuartoEntity tipoQuarto) {
        this.idQuarto = idQuarto;
        this.idPredio = idPredio;
        this.idHotel = idHotel;
        this.valorDiaria = valorDiaria;
        this.status = status;
        this.tipoQuarto = tipoQuarto;
    }


    public Quarto toQuarto(){
        Quarto quarto = new Quarto(
                this.idQuarto,
                this.idHotel,
                this.valorDiaria,
                this.status,
                this.tipoQuarto
        );

        return quarto;
    }

    public Long getIdQuarto() {
        return idQuarto;
    }

    public Long getIdPredio() {
        return idPredio;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public BigDecimal getValorDiaria() {
        return valorDiaria;
    }

    public Status getStatus() {
        return status;
    }

    public TipoQuartoEntity getTipoQuarto() {
        return tipoQuarto;
    }
}
