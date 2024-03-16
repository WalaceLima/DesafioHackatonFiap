package com.fiap.desafioHackaton.domain.hotel.item.gateway;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemGateway {

    Item criar(Item item);

    Item atualizar(Item item);

    List<Item> listar();

    Optional<Item> buscarPorId(Long id);

    void deletar(Item item);
}
