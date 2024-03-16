package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.item.dto.ItemPublicData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelItensPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<ItemPublicData> itens

) {

    public HotelItensPublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getItensDiponiveis().stream().map(item -> new ItemPublicData(item)).collect(Collectors.toList())
        );
    }
}
