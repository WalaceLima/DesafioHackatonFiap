package com.fiap.desafioHackaton.infraestructure.predio.dto;

import com.fiap.desafioHackaton.domain.predio.entity.Predio;
import com.fiap.desafioHackaton.infraestructure.hotel.dto.HotelPublicData;
import com.fiap.desafioHackaton.infraestructure.quarto.dto.QuartoSummaryPublicData;

import java.util.List;

public record PredioPublicData (

         HotelPublicData hotel,
         Long id,
         String nome,
         List<QuartoSummaryPublicData> quartos


) {
    public PredioPublicData(Predio predio) {
        this(
                new HotelPublicData(predio.getHotel()),
                predio.getId(),
                predio.getNome(),
                predio.getQuartos().stream().map(QuartoSummaryPublicData::new).toList()
        );
    }
}
