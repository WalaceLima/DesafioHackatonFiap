package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.usecase.predio.dto.IPredioRequestData;

public record PredioRequestData(
        String nome


) implements IPredioRequestData {
}
