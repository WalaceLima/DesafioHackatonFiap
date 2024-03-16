package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;

public record PredioPublicResponseAddData(
        Long id,
        String nome
) {
    public PredioPublicResponseAddData(Predio predio) {
        this(
                predio.getId(),
                predio.getNome()
        );
    }
}
