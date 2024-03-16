package com.fiap.desafioHackaton.usecase.hotel.dto;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;

public interface IHotelAtualizarRequestData {

    String nome();

    Endereco endereco();


}
