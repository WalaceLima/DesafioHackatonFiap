package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.predio.gateway.PredioGateway;

public class DeletarHotelUseCase {

    private final HotelGateway hotelGateway;

    private final PredioGateway predioGateway;
    public DeletarHotelUseCase(HotelGateway hotelGateway, PredioGateway predioGateway) {
        this.hotelGateway = hotelGateway;
        this.predioGateway = predioGateway;
    }

    public void executar(Long id) {
        Hotel hotel = this.hotelGateway.buscarPorId(id).orElseThrow();
        this.predioGateway.removerReferenciaHotel(hotel);
        this.hotelGateway.deletar(hotel);

    }

}
