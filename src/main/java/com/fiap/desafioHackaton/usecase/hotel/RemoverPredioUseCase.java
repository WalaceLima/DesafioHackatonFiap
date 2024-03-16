package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.usecase.predio.DeletarPredioUseCase;

public class RemoverPredioUseCase {

    private final HotelGateway hotelGateway;
    private final DeletarPredioUseCase deletarPredioUseCase;

    public RemoverPredioUseCase(HotelGateway hotelGateway, DeletarPredioUseCase deletarPredioUseCase) {
        this.hotelGateway = hotelGateway;
        this.deletarPredioUseCase = deletarPredioUseCase;
    }

    public Hotel executar(Long hotelId, Long predioId) {
        Hotel hotel = this.hotelGateway.buscarPorId(hotelId).orElseThrow();

        this.deletarPredioUseCase.executar(predioId);

        return hotel;

    }

}
