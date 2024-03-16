package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.infraestructure.endereco.dto.EnderecoCadastroRequestData;
import com.fiap.desafioHackaton.usecase.hotel.dto.IHotelCadastroRequestData;

public record HotelCadastroRequestData(
        String nome,
        EnderecoCadastroRequestData endereco


) implements IHotelCadastroRequestData {


}
