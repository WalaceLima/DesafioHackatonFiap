package com.fiap.desafioHackaton.usecase.quarto.dto;

import java.math.BigDecimal;

public interface IQuartoRequestData {
    Long idPredio();

    Long idTipoQuarto();

    String status();

    BigDecimal valorDiaria();
}
