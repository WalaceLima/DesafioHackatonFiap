package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;

public record HotelPublicData(

        Long id,
        String nome,
        Endereco endereco


) {
    public HotelPublicData(Hotel hotel) {

        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco()

        );

    }

}
