package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import com.fiap.desafioHackaton.domain.quarto.entity.Quarto;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public record QuartoSummaryPublicData (Long id,
                                       Status status,
                                       BigDecimal valorDiaria,
                                       TipoQuarto tipoQuarto
) {

    public QuartoSummaryPublicData(Quarto quarto) {
        this(
                quarto.getId(),
                quarto.getStatus(),
                quarto.getValorDiaria(),
                quarto.getTipoQuarto()
        );
    }
}
