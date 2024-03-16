package com.fiap.desafioHackaton.infraestructure.hotel.item.dto;

import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.usecase.item.dto.IItemPublicData;

import java.math.BigDecimal;

public record ItemPublicData(
        Long id,
        String nome,
        BigDecimal valor
) implements IItemPublicData {

    public ItemPublicData(Item item) {
        this(
                item.getId(),
                item.getNome(),
                item.getValor()
        );
    }
}