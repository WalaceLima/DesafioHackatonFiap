package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.usecase.hotel.dto.IHotelAtualizarRequestData;

public class AtualizarHotelUseCase {

    private final HotelGateway hotelGateway;


    public AtualizarHotelUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public Hotel executar(Long hotelId, IHotelAtualizarRequestData dados) {
        Hotel hotel = this.hotelGateway.buscarPorId(hotelId).orElseThrow();
        hotel.setNome(dados.nome());
        hotel.setEndereco(dados.endereco());


        return this.hotelGateway.atualizar(hotel);

    }
}
