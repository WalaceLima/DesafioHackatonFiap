package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public record QuartoSearchResponseData(
        Long id,
        Long predioId,
        Long hotelId,
        TipoQuarto tipoQuarto,
        Status status,
        BigDecimal valorDiaria
) {

    public QuartoSearchResponseData(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getPredio().getId(),
                quarto.getIdHotel(),
                quarto.getTipoQuarto(),
                quarto.getStatus(),
                quarto.getValorDiaria()
        );
    }
}
