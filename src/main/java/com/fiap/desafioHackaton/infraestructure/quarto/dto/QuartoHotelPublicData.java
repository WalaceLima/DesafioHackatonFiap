package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public record QuartoHotelPublicData(
        Long id,
        TipoQuarto tipoQuarto,
        Status status,
        BigDecimal valorDiaria
) {
    public QuartoHotelPublicData(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getTipoQuarto(),
                quarto.getStatus(),
                quarto.getValorDiaria()
        );
    }
}
