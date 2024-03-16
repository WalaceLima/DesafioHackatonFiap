package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.usecase.hotel.dto.IHotelAtualizarRequestData;

public record HotelAtualizarRequestData(
        String nome,
        Endereco endereco

) implements IHotelAtualizarRequestData {

}
