package com.fiap.desafioHackaton.usecase.item;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.item.exception.ItemNaoEncontradoException;
import com.fiap.desafioHackaton.domain.hotel.item.gateway.ItemGateway;

import java.util.Optional;

public class BuscarItemUseCase {

    private final ItemGateway itemGateway;

    public BuscarItemUseCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public Item execute(Long id) {
        Optional<Item> item = this.itemGateway.buscarPorId(id);
        if (item.isEmpty()) {
            throw new ItemNaoEncontradoException();
        }

        return item.get();
    }
}