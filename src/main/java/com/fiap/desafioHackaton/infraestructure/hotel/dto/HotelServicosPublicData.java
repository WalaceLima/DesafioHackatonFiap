package com.fiap.desafioHackaton.infraestructure.hotel.dto;

import com.fiap.desafioHackaton.domain.endereco.entity.Endereco;
import com.fiap.desafioHackaton.domain.hotel.entity.Hotel;
import com.fiap.desafioHackaton.infraestructure.hotel.servico.dto.ServicoPublicData;

import java.util.List;
import java.util.stream.Collectors;

public record HotelServicosPublicData(
        Long id,
        String nome,
        Endereco endereco,
        List<ServicoPublicData> servicos


) {

    public HotelServicosPublicData(Hotel hotel) {
        this(
                hotel.getId(),
                hotel.getNome(),
                hotel.getEndereco(),
                hotel.getServicosDisponiveis().stream().map(servico -> new ServicoPublicData(servico)).collect(Collectors.toList())
        );
    }
}
