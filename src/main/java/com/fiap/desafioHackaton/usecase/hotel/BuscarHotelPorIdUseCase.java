package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;

public class BuscarHotelPorIdUseCase {

    private final HotelGateway hotelGateway;


    public BuscarHotelPorIdUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public Hotel buscarPorId(Long id) {
        return this.hotelGateway.buscarPorId(id).orElseThrow();
    }

}
