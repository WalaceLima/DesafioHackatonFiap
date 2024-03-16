package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.domain.amenidade.entity.Amenidade;
import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.domain.hotel.item.entity.Item;
import com.fiap.desafioHackaton.domain.hotel.servico.entity.Servico;
import com.fiap.desafioHackaton.infraestructure.predio.dto.PredioPublicMinimalData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelCompletePublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<PredioPublicMinimalData> predios,
        List<Amenidade> amenidades,
        List<Servico> servicosDisponiveis,
        List<Item> itensDiponiveis


) {

    public HotelCompletePublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getPredios().stream().map(PredioPublicMinimalData::new).collect(Collectors.toList()),
                hotel.getAmenidades(),
                hotel.getServicosDisponiveis(),
                hotel.getItensDiponiveis()

        );
    }
}
