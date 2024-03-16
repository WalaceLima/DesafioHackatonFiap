package com.fiap.desafioHackaton.usecase.hotel.dto;

import com.fiap.desafioHackaton.infraestructure.endereco.dto.EnderecoCadastroRequestData;

public interface IHotelCadastroRequestData {
    String nome();

    EnderecoCadastroRequestData endereco();
}
