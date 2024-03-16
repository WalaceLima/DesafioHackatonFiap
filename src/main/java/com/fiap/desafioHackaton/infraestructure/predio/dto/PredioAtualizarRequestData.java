package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.usecase.predio.dto.IPredioUpdateData;

public record PredioAtualizarRequestData(
        String nome
) implements IPredioUpdateData {
}
