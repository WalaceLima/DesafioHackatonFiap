package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicResponseAddData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelPrediosPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<PredioPublicResponseAddData> predios


) {
    public HotelPrediosPublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getPredios().stream().map(predio -> new PredioPublicResponseAddData(predio)).collect(Collectors.toList())
        );
    }

}
