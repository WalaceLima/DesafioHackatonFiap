package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import java.time.LocalDate;

public record RecomendarQuartoRequestData(
        LocalDate dataInicio,
        LocalDate dataFim,
        Integer quantidadePessoas,
        Integer numeroSugestoes
) {



}
