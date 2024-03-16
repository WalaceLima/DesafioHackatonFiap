package com.fiap.desafioHackaton.usecase.hotel;

import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.usecase.item.BuscarItemUseCase;

public class AdicionarItemUseCase {


    private final HotelGateway hotelGateway;
    private final BuscarItemUseCase buscarItemUseCase;

    public AdicionarItemUseCase(HotelGateway hotelGateway, BuscarItemUseCase buscarItemUseCase) {
        this.hotelGateway = hotelGateway;
        this.buscarItemUseCase = buscarItemUseCase;
    }


    public Hotel executar(Long hotelId, Long itemId) {
        Hotel hotel = hotelGateway.buscarPorId(hotelId).orElseThrow();
        Item item = buscarItemUseCase.execute(itemId);

        hotel.addItem(item);


        return hotelGateway.adicionarItem(hotel);

    }

}
