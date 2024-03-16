package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoHotelPublicData;

import java.util.List;
import java.util.stream.Collectors;

public record PredioPublicMinimalData(

        Long id,
        String nome,
        List<QuartoHotelPublicData> quartos


) {

    public PredioPublicMinimalData(Predio predio) {
        this(
                predio.getId(),
                predio.getNome(),
                predio.getQuartos().stream().map(QuartoHotelPublicData::new).collect(Collectors.toList())
        );
    }
}
