package com.fiap.desafioHackaton.infraestructure.quarto.dto;

import java.util.List;

public record QuartoRecomendacaoPublicData(
        List<List<QuartoHotelPublicData>> quartosCombinacoes
) {


}
