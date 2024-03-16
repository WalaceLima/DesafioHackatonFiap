package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.gateway.HotelGateway;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;

public class DeletarItemUseCase {

    private final ItemGateway itemGateway;

    private final HotelGateway hotelGateway;
    public DeletarItemUseCase(ItemGateway itemGateway, HotelGateway hotelGateway) {

        this.itemGateway = itemGateway;
        this.hotelGateway = hotelGateway;
    }

    public void execute(Long id) {
        Item item = this.itemGateway.buscarPorId(id).orElseThrow();
        this.hotelGateway.removerRelacionamentoItem(item);
        this.itemGateway.deletar(item);
    }
}
