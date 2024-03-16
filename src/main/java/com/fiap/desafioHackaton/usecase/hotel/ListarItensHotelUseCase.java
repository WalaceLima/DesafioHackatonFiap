package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;

import java.util.List;

public class ListarItensHotelUseCase {

    private final HotelGateway hotelGateway;

    public ListarItensHotelUseCase(HotelGateway hotelGateway) {
        this.hotelGateway = hotelGateway;
    }

    public List<Item> executar(Long id) {
        Hotel hotel = hotelGateway.buscarPorId(id).orElseThrow();
        return hotel.getItensDiponiveis();
    }

}
