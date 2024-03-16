package com.fiap.desafioHackaton.usecase.quarto.dto;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.domain.quarto.entity.Status;
import com.fiap.desafioHackaton.domain.quarto.tipoquarto.entity.TipoQuarto;

import java.math.BigDecimal;

public interface IQuartoPublicData {
    Long id();

    Predio predio();

    TipoQuarto tipoQuarto();

    Status status();

    BigDecimal valorDiaria();

}
